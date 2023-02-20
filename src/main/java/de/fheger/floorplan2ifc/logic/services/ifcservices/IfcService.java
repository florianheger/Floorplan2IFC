package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.gui.nodes.EntityNode;
import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.EntityNodeWithChildren;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.AddAttributes;
import de.fheger.floorplan2ifc.logic.services.ifcservices.relationships.AddRelationships;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;

import java.util.ArrayList;
import java.util.List;

public abstract class IfcService<IfcType extends IfcObjectDefinition, NodeType extends EntityNode<?>> {

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

    @SuppressWarnings("unused")
    protected IfcService(Class<IfcType> clazzIfc, Class<NodeType> clazzNode, FindIfcEntityService findIfcEntityService,
                         AddRelationships<IfcType, NodeType> addRelationships) {
        this.clazzIfc = clazzIfc;
        this.clazzNode = clazzNode;
        this.findIfcEntityService = findIfcEntityService;
        this.addRelationships = addRelationships;
    }


    public void addAttributesAndRelationships(IfcProject ifcProject, de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.ProjectNode projectNode)
            throws ParseToIfcException {
        List<NodeType> nodes = getNodesOfNodeType(projectNode);
        for (NodeType node : nodes) {
            IfcType ifcEntity = findIfcEntityService.findIfcEntity(ifcProject, node.getEntityPanel().getGlobalId(), clazzIfc);
            if (addAttributes != null) {
                addAttributes.addAttributes(ifcEntity, node);
            }
            if (addRelationships != null) {
                addRelationships.addRelationships(ifcEntity, node);
            }
        }
    }

    protected List<NodeType> getNodesOfNodeType(EntityNode<?> entityNode) {
        List<NodeType> nodes = new ArrayList<>();
        if (clazzNode.isInstance(entityNode)) {
            nodes.add(clazzNode.cast(entityNode));
        }
        if (!(entityNode instanceof EntityNodeWithChildren<?> entityNodeWithChilds)) {
            return nodes;
        }
        for (EntityNode<?> entityNodeChild : entityNodeWithChilds.getEntityNodeChildren()) {
            nodes.addAll(getNodesOfNodeType(entityNodeChild)); // stimmt das?
        }
        return nodes;
    }
}
