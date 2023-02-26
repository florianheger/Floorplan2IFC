package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.gui.entityinterfaces.IEntity;
import de.fheger.floorplan2ifc.gui.entityinterfaces.IProject;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.IAddAttributesService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.relationships.IAddRelationshipsService;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;

import java.util.ArrayList;
import java.util.List;

public abstract class IfcService<IfcType extends IfcObjectDefinition, IEntityType extends IEntity> {

    private final Class<IEntityType> clazzNode;
    private final Class<IfcType> clazzIfc;
    private final FindIfcEntityService findIfcEntityService;

    private IAddRelationshipsService<IfcType, IEntityType> addRelationshipsService;
    private IAddAttributesService<IfcType, IEntityType> addAttributesService;

    protected IfcService(Class<IfcType> clazzIfc, Class<IEntityType> clazzNode, FindIfcEntityService findIfcEntityService,
                         IAddAttributesService<IfcType, IEntityType> addAttributesService, IAddRelationshipsService<IfcType, IEntityType> addRelationshipsService) {
        this.clazzIfc = clazzIfc;
        this.clazzNode = clazzNode;
        this.findIfcEntityService = findIfcEntityService;
        this.addRelationshipsService = addRelationshipsService;
        this.addAttributesService = addAttributesService;
    }

    protected IfcService(Class<IfcType> clazzIfc, Class<IEntityType> clazzNode, FindIfcEntityService findIfcEntityService,
                         IAddAttributesService<IfcType, IEntityType> addAttributesService) {
        this.clazzIfc = clazzIfc;
        this.clazzNode = clazzNode;
        this.findIfcEntityService = findIfcEntityService;
        this.addAttributesService = addAttributesService;
    }

    @SuppressWarnings("unused")
    protected IfcService(Class<IfcType> clazzIfc, Class<IEntityType> clazzNode, FindIfcEntityService findIfcEntityService,
                         IAddRelationshipsService<IfcType, IEntityType> addRelationshipsService) {
        this.clazzIfc = clazzIfc;
        this.clazzNode = clazzNode;
        this.findIfcEntityService = findIfcEntityService;
        this.addRelationshipsService = addRelationshipsService;
    }


    public void addAttributesAndRelationships(IfcProject ifcProject, IProject iProject)
            throws ParseToIfcException {
        List<IEntityType> nodes = getNodesOfNodeType(iProject);
        for (IEntityType node : nodes) {
            IfcType ifcEntity = findIfcEntityService.findIfcEntity(ifcProject, node.getGlobalId(), clazzIfc);
            if (addAttributesService != null) {
                addAttributesService.addAttributes(ifcEntity, node);
            }
            if (addRelationshipsService != null) {
                addRelationshipsService.addRelationships(ifcEntity, node);
            }
        }
    }

    protected List<IEntityType> getNodesOfNodeType(IEntity entity) {
        List<IEntityType> nodes = new ArrayList<>();
        if (clazzNode.isInstance(entity)) {
            nodes.add(clazzNode.cast(entity));
        }
        if (!entity.hasChildren()) {
            return nodes;
        }
        for (IEntity child : entity.getIEntityChildren()) {
            nodes.addAll(getNodesOfNodeType(child));
        }
        return nodes;
    }
}
