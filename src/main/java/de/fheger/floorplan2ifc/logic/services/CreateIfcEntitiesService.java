package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.gui.ElementNode;
import de.fheger.floorplan2ifc.gui.nodes.ElementNodeWithChilds;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.*;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.IfcElement;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcDoor;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWindow;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.featureelement.featureelementsubtraction.IfcOpeningElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.relconnects.IfcRelFillsElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelAggregates;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelVoidsElement;
import de.fheger.floorplan2ifc.models.enums.IfcOpeningElementTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class CreateIfcEntitiesService {

    private final CreateIfcEntityWithRootAttributesService createIfcEntityWithRootAttributes;

    @Autowired
    public CreateIfcEntitiesService(CreateIfcEntityWithRootAttributesService createIfcEntityWithRootAttributesService) {
        this.createIfcEntityWithRootAttributes = createIfcEntityWithRootAttributesService;
    }

    public IfcProject createIfcEntitiesService(ProjectNode projectNode)
            throws ParseToIfcException {
        IfcProject ifcProject = createIfcEntityWithRootAttributes.createIfcEntityWithRootAttributesTypeSave(projectNode.getElementPanel(), IfcProject.class);
        List<ElementNode<?>> children = projectNode.getElementNodeChildren();
        for (ElementNode<?> child : children) {
            addIfcEntitiesRecursive(ifcProject, child);
        }
        return ifcProject;
    }

    private void addIfcEntitiesRecursive(IfcObjectDefinition parent, ElementNode<?> child)
            throws ParseToIfcException {
        IfcObjectDefinition ifcChild = createIfcEntityWithRootAttributes.createIfcEntityWithRootAttributes(child.getElementPanel());
        addRelAggregates(parent, ifcChild);
        if (!(child instanceof ElementNodeWithChilds<?> childWithChildren)) {
            return;
        }
        List<ElementNode<?>> childrenOfChild = childWithChildren.getElementNodeChildren();
        for (ElementNode<?> childOfChild : childrenOfChild) {
            addIfcEntitiesRecursive(ifcChild, childOfChild);
        }
    }

    private void addRelAggregates(IfcObjectDefinition parent, IfcObjectDefinition child)
            throws ParseToIfcException {
        if (needsOpeningElement(child)) {
            addOpeningElement(parent, child);
            return;
        }
        IfcRelAggregates relParentChild = getRelAggregates(parent);
        relParentChild.getRelatedObjects().add(child);
        child.getDecomposes().add(relParentChild);
    }

    private void addOpeningElement(IfcObjectDefinition parent, IfcObjectDefinition child)
            throws ParseToIfcException {
        if (!(parent instanceof IfcElement parentE)) {
            throw new ParseToIfcException(parent.getClass().getSimpleName() + " should be of type IfcElement.");
        }
        if (!(child instanceof IfcElement childE)) {
            throw new ParseToIfcException(child.getClass().getSimpleName() + " should be of type IfcElement.");
        }

        IfcOpeningElement ifcOpeningElement = new IfcOpeningElement();
        ifcOpeningElement.setPredefinedType(IfcOpeningElementTypeEnum.OPENING);

        IfcRelVoidsElement relWallOpening = new IfcRelVoidsElement(parentE, ifcOpeningElement);
        parentE.getHasOpenings().add(relWallOpening);
        ifcOpeningElement.getVoidsElements().add(relWallOpening);

        IfcRelFillsElement relOpeningDoorOrWindow = new IfcRelFillsElement(ifcOpeningElement, childE);
        ifcOpeningElement.getHasFillings().add(relOpeningDoorOrWindow);
        childE.getFillsVoids().add(relOpeningDoorOrWindow);
    }

    private IfcRelAggregates getRelAggregates(IfcObjectDefinition parent) {
        if (parent.getIsDecomposedBy().size() > 0) {
            return parent.getIsDecomposedBy().stream().toList().get(0);
        }
        IfcRelAggregates ifcRelAggregates = new IfcRelAggregates(parent, new HashSet<>());
        parent.getIsDecomposedBy().add(ifcRelAggregates);
        return ifcRelAggregates;
    }

    private boolean needsOpeningElement(IfcObjectDefinition child) {
        return (child instanceof IfcDoor || child instanceof IfcWindow);
    }
}
