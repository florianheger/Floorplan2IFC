package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.gui.ElementNode;
import de.fheger.floorplan2ifc.gui.nodes.ElementNodeWithChilds;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.AddAttributes;
import de.fheger.floorplan2ifc.logic.services.ifcservices.relationships.AddRelationships;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;

import java.util.ArrayList;
import java.util.List;

public abstract class IfcService<IfcType extends IfcObjectDefinition, NodeType extends ElementNode<?>> {

    private final Class<NodeType> clazzNode;
    private final Class<IfcType> clazzIfc;
    private final FindIfcEntityService findIfcEntityService;

    private AddRelationships<IfcType, NodeType> addRelationships;
    private AddAttributes<IfcType, NodeType> addAttributes;

    protected IfcService(Class<IfcType> clazzIfc, Class<NodeType> clazzNode, FindIfcEntityService findIfcEntityService,
                         AddAttributes<IfcType, NodeType> addAttributes, AddRelationships<IfcType, NodeType> addRelationships) {
        this.clazzIfc = clazzIfc;
        this.clazzNode = clazzNode;
        this.findIfcEntityService = findIfcEntityService;
        this.addRelationships = addRelationships;
        this.addAttributes = addAttributes;
    }

    protected IfcService(Class<IfcType> clazzIfc, Class<NodeType> clazzNode, FindIfcEntityService findIfcEntityService,
                         AddAttributes<IfcType, NodeType> addAttributes) {
        this.clazzIfc = clazzIfc;
        this.clazzNode = clazzNode;
        this.findIfcEntityService = findIfcEntityService;
        this.addAttributes = addAttributes;
    }

    protected IfcService(Class<IfcType> clazzIfc, Class<NodeType> clazzNode, FindIfcEntityService findIfcEntityService,
                         AddRelationships<IfcType, NodeType> addRelationships) {
        this.clazzIfc = clazzIfc;
        this.clazzNode = clazzNode;
        this.findIfcEntityService = findIfcEntityService;
        this.addRelationships = addRelationships;
    }


    public void addAttributesAndRelationships(IfcProject ifcProject, ProjectNode projectNode)
            throws ParseToIfcException {
        List<NodeType> nodes = getNodesOfNodeType(projectNode);
        for (NodeType node : nodes) {
            IfcType ifcEntity = findIfcEntityService.findIfcEntity(ifcProject, node.getElementPanel().getGlobalId(), clazzIfc);
            if (addAttributes != null) {
                addAttributes.addAttributes(ifcEntity, node);
            }
            if (addRelationships != null) {
                addRelationships.addRelationships(ifcEntity, node);
            }
        }
    }

    protected List<NodeType> getNodesOfNodeType(ElementNode<?> elementNode) {
        List<NodeType> nodes = new ArrayList<>();
        if (clazzNode.isInstance(elementNode)) {
            nodes.add(clazzNode.cast(elementNode));
        }
        if (!(elementNode instanceof ElementNodeWithChilds<?> elementNodeWithChilds)) {
            return nodes;
        }
        for (ElementNode<?> elementNodeChild : elementNodeWithChilds.getElementNodeChildren()) {
            nodes.addAll(getNodesOfNodeType(elementNodeChild)); // stimmt das?
        }
        return nodes;
    }
}
