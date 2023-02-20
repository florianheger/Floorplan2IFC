package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.gui.nodes.EntityNode;
import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.EntityNodeWithChildren;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.IAddAttributesService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.relationships.IAddRelationshipsService;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;

import java.util.ArrayList;
import java.util.List;

public abstract class IfcService<IfcType extends IfcObjectDefinition, NodeType extends
        EntityNode<?>> {

    private final Class<NodeType> clazzNode;
    private final Class<IfcType> clazzIfc;
    private final FindIfcEntityService findIfcEntityService;

    private IAddRelationshipsService<IfcType, NodeType> addRelationshipsService;
    private IAddAttributesService<IfcType, NodeType> addAttributesService;

    protected IfcService(Class<IfcType> clazzIfc, Class<NodeType> clazzNode, FindIfcEntityService findIfcEntityService,
                         IAddAttributesService<IfcType, NodeType> addAttributesService, IAddRelationshipsService<IfcType, NodeType> addRelationshipsService) {
        this.clazzIfc = clazzIfc;
        this.clazzNode = clazzNode;
        this.findIfcEntityService = findIfcEntityService;
        this.addRelationshipsService = addRelationshipsService;
        this.addAttributesService = addAttributesService;
    }

    protected IfcService(Class<IfcType> clazzIfc, Class<NodeType> clazzNode, FindIfcEntityService findIfcEntityService,
                         IAddAttributesService<IfcType, NodeType> addAttributesService) {
        this.clazzIfc = clazzIfc;
        this.clazzNode = clazzNode;
        this.findIfcEntityService = findIfcEntityService;
        this.addAttributesService = addAttributesService;
    }

    @SuppressWarnings("unused")
    protected IfcService(Class<IfcType> clazzIfc, Class<NodeType> clazzNode, FindIfcEntityService findIfcEntityService,
                         IAddRelationshipsService<IfcType, NodeType> addRelationshipsService) {
        this.clazzIfc = clazzIfc;
        this.clazzNode = clazzNode;
        this.findIfcEntityService = findIfcEntityService;
        this.addRelationshipsService = addRelationshipsService;
    }


    public void addAttributesAndRelationships(IfcProject ifcProject, de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.ProjectNode projectNode)
            throws ParseToIfcException {
        List<NodeType> nodes = getNodesOfNodeType(projectNode);
        for (NodeType node : nodes) {
            IfcType ifcEntity = findIfcEntityService.findIfcEntity(ifcProject, node.getEntityPanel().getGlobalId(), clazzIfc);
            if (addAttributesService != null) {
                addAttributesService.addAttributes(ifcEntity, node);
            }
            if (addRelationshipsService != null) {
                addRelationshipsService.addRelationships(ifcEntity, node);
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
