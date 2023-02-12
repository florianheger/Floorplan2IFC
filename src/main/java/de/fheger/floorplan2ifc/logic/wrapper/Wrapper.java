package de.fheger.floorplan2ifc.logic.wrapper;

import de.fheger.floorplan2ifc.gui.ElementNode;
import de.fheger.floorplan2ifc.gui.ElementPanel;
import de.fheger.floorplan2ifc.gui.nodes.DoorNode;
import de.fheger.floorplan2ifc.gui.nodes.ElementNodeWithChilds;
import de.fheger.floorplan2ifc.gui.nodes.SanitaryTerminalNode;
import de.fheger.floorplan2ifc.gui.nodes.WindowNode;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.*;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.CreateIfcEntityWithRootAttributesService;
import de.fheger.floorplan2ifc.logic.wrapper.products.*;
import de.fheger.floorplan2ifc.logic.wrapper.products.doororwindowwrapper.DoorWrapper;
import de.fheger.floorplan2ifc.logic.wrapper.products.doororwindowwrapper.WindowWrapper;
import de.fheger.floorplan2ifc.models.entities.IfcRoot;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelAggregates;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public abstract class Wrapper<NodeType extends ElementNode<?>, IfcType extends IfcObjectDefinition> {
    @Getter(AccessLevel.PROTECTED)
    private final NodeType elementNode;

    @Getter(AccessLevel.PROTECTED)
    private final IfcType ifcElement;

    private static final ArrayList<Wrapper<?, ?>> allWrappers = new ArrayList<>();

    protected Wrapper(NodeType elementNode, IfcType ifcElement) {
        this.elementNode = elementNode;
        this.ifcElement = ifcElement;
        allWrappers.add(this);
    }

    public void addRelAggregatesToChildren() throws ParseToIfcException {
        if (!(elementNode instanceof ElementNodeWithChilds<?> elementNodeWithChildren)) {
            return;
        }

        List<IfcObjectDefinition> ifcChildren = getChildren(elementNodeWithChildren);

        IfcRelAggregates relThisChildren = new IfcRelAggregates(this.ifcElement, new HashSet<>(ifcChildren));
        ifcElement.getIsDecomposedBy().add(relThisChildren);
        for (IfcObjectDefinition ifcChild : ifcChildren) {
            ifcChild.getDecomposes().add(relThisChildren);
        }
    }

    private List<IfcObjectDefinition> getChildren(ElementNodeWithChilds<?> elementNodeWithChildren) throws ParseToIfcException {
        List<ElementNode<?>> children = elementNodeWithChildren.getElementNodeChildren();
        List<IfcObjectDefinition> ifcChildren = new ArrayList<>();
        for (Wrapper<?, ?> currentWrapper : allWrappers) {
            if (children.stream().noneMatch(c -> c == currentWrapper.elementNode)) {
                continue;
            }
            if (isStandardRelationship(currentWrapper.ifcElement)) {
                ifcChildren.add(currentWrapper.ifcElement);
            } else {
                addSpecialRelationship(currentWrapper.ifcElement);
            }

        }
        return ifcChildren;
    }


    protected <SearchedIfcType extends IfcRoot> List<SearchedIfcType> getIfcElements(ElementPanel[] elementPanels, Class<SearchedIfcType> clazz)
            throws ParseToIfcException {
        List<SearchedIfcType> ifcElements = new ArrayList<>();
        for (Wrapper<?, ?> currentWrapper : allWrappers) {

            ElementPanel currentPanel = currentWrapper.getElementNode().getElementPanel();
            if (Arrays.stream(elementPanels).noneMatch(panel -> panel == currentPanel)) {
                continue;
            }
            if (!clazz.isInstance(currentWrapper.getIfcElement())) {
                throw new ParseToIfcException("should not happen; elementpanel is associated with another IfcType than given in clazz");
            }
            ifcElements.add(clazz.cast(currentWrapper.getIfcElement()));
        }
        if (elementPanels.length != ifcElements.size()) {
            throw new RuntimeException("Not all IfcElements were found during parsing");
        }
        return ifcElements;
    }

    public IfcProject getIfcProjectAndClean()
            throws ParseToIfcException {
        for (Wrapper<?, ?> w : allWrappers) {
            if (w.getIfcElement() instanceof IfcProject ifcProject) {
                clearWrappers();
                return ifcProject;
            }
        }
        throw new ParseToIfcException("Internal error; found no IfcProject after parsing");
    }

    private void clearWrappers() {
        allWrappers.clear();
    }

    protected boolean isStandardRelationship(IfcObjectDefinition child) {
        return true;
    }

    protected void addSpecialRelationship(IfcObjectDefinition child)
            throws ParseToIfcException {
    }

    public void addAttributes() throws ParseToIfcException {
//        CreateIfcEntityWithRootAttributesService.addRootAttributes(ifcElement, elementNode.getElementPanel());
    }

    public abstract void addRelationships() throws ParseToIfcException;

    public static Wrapper<?, ?> getMatchingWrapper(ElementNode<?> elementNode)
            throws ParseToIfcException {
        if (elementNode instanceof ProjectNode projectNode) {
            return new ProjectWrapper(projectNode);
        }
        if (elementNode instanceof SiteNode siteNode) {
            return new SiteWrapper(siteNode);
        }
        if (elementNode instanceof BuildingNode buildingNode) {
            return new BuildingWrapper(buildingNode);
        }
        if (elementNode instanceof BuildingStoreyNode buildingStoreyNode) {
            return new BuildingStoreyWrapper(buildingStoreyNode);
        }
        if (elementNode instanceof WallNode wallNode) {
            return new WallWrapper(wallNode);
        }
        if (elementNode instanceof SpaceNode spaceNode) {
            return new SpaceWrapper(spaceNode);
        }
        if (elementNode instanceof DoorNode doorNode) {
            return new DoorWrapper(doorNode);
        }
        if (elementNode instanceof WindowNode windowNode) {
            return new WindowWrapper(windowNode);
        }
        if (elementNode instanceof SanitaryTerminalNode sanitaryTerminalNode) {
            return new SanitaryTerminalWrapper(sanitaryTerminalNode);
        }
        throw new ParseToIfcException("Found not supported Node");
    }
}
