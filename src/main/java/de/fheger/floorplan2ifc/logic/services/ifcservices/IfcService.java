package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.interfaces.IEntity;
import de.fheger.floorplan2ifc.interfaces.IProject;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.IAddAttributesService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.relationships.IAddRelationshipsService;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract superclass for any IFC-Class that has attributes and/or relationships.
 *
 * @param <IfcType>     The corresponding subclass of IfcObjectDefinition.
 * @param <IEntityType> The corresponding subclass of IEntity.
 */
public abstract class IfcService<IfcType extends IfcObjectDefinition, IEntityType extends IEntity> {

    private final Class<IEntityType> clazzNode;
    private final Class<IfcType> clazzIfc;
    private final FindIfcEntityService findIfcEntityService;

    private IAddRelationshipsService<IfcType, IEntityType> addRelationshipsService;
    private IAddAttributesService<IfcType, IEntityType> addAttributesService;

    /**
     * If the IFC-class has attributes and relationships.
     *
     * @param clazzIfc                Class object of <i>IfcType</i>.
     * @param clazzNode               Class object of <i>IEntityType</i>.
     * @param findIfcEntityService    Object of <i>IfcEntityService</i>.
     * @param addAttributesService    The corresponding implementation of AddAttributesService.
     * @param addRelationshipsService The corresponding implementation of AddRelationshipsService.
     */
    protected IfcService(Class<IfcType> clazzIfc, Class<IEntityType> clazzNode, FindIfcEntityService findIfcEntityService,
                         IAddAttributesService<IfcType, IEntityType> addAttributesService, IAddRelationshipsService<IfcType, IEntityType> addRelationshipsService) {
        this.clazzIfc = clazzIfc;
        this.clazzNode = clazzNode;
        this.findIfcEntityService = findIfcEntityService;
        this.addRelationshipsService = addRelationshipsService;
        this.addAttributesService = addAttributesService;
    }

    /**
     * If the IFC-class has attributes only.
     *
     * @param clazzIfc             Class object of <i>IfcType</i>.
     * @param clazzNode            Class object of <i>IEntityType</i>.
     * @param findIfcEntityService Object of <i>IfcEntityService</i>.
     * @param addAttributesService The corresponding implementation of AddAttributesService.
     */
    protected IfcService(Class<IfcType> clazzIfc, Class<IEntityType> clazzNode, FindIfcEntityService findIfcEntityService,
                         IAddAttributesService<IfcType, IEntityType> addAttributesService) {
        this.clazzIfc = clazzIfc;
        this.clazzNode = clazzNode;
        this.findIfcEntityService = findIfcEntityService;
        this.addAttributesService = addAttributesService;
    }

    /**
     * If the IFC-class has relationships only.
     *
     * @param clazzIfc                Class object of <i>IfcType</i>.
     * @param clazzNode               Class object of <i>IEntityType</i>.
     * @param findIfcEntityService    Object of <i>IfcEntityService</i>.
     * @param addRelationshipsService The corresponding implementation of AddRelationshipsService.
     */
    @SuppressWarnings("unused")
    protected IfcService(Class<IfcType> clazzIfc, Class<IEntityType> clazzNode, FindIfcEntityService findIfcEntityService,
                         IAddRelationshipsService<IfcType, IEntityType> addRelationshipsService) {
        this.clazzIfc = clazzIfc;
        this.clazzNode = clazzNode;
        this.findIfcEntityService = findIfcEntityService;
        this.addRelationshipsService = addRelationshipsService;
    }

    /**
     * Runs the implementations of IAddAttributesService and/or IAddRelationshipsService.
     *
     * @param ifcProject Corresponding IfcProject.
     * @param iProject   Corresponding IProject.
     * @throws ParseToIfcException In case of any error that prevents the creation the attributes/relationships.
     */
    public void addAttributesAndRelationships(IfcProject ifcProject, IProject iProject)
            throws ParseToIfcException {
        List<IEntityType> nodes = getIEntityTypeObjects(iProject);
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

    protected List<IEntityType> getIEntityTypeObjects(IEntity entity) {
        List<IEntityType> nodes = new ArrayList<>();
        if (clazzNode.isInstance(entity)) {
            nodes.add(clazzNode.cast(entity));
        }
        if (!entity.hasChildren()) {
            return nodes;
        }
        entity.getIEntityChildren().forEach(
                child -> nodes.addAll(getIEntityTypeObjects(child))
        );
        return nodes;
    }
}
