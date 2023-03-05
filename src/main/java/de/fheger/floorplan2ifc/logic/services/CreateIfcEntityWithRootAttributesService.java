package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.interfaces.*;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.IfcRoot;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.*;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.distributionelement.distributionflowelement.flowterminal.IfcSanitaryTerminal;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcBuildingStorey;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSite;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSpace;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.facility.IfcBuilding;
import org.springframework.stereotype.Service;

@Service
public class CreateIfcEntityWithRootAttributesService {
    /**
     * Creates a new IFC-Object. Returns
     *
     * @param iEntity
     * @return
     * @throws ParseToIfcException
     */
    public IfcObjectDefinition createIfcEntityWithRootAttributes(IEntity iEntity)
            throws ParseToIfcException {
        IfcObjectDefinition ifcEntity = createIfcEntity(iEntity);
        addRootAttributes(ifcEntity, iEntity);

        return ifcEntity;
    }

    /**
     * Creates a new IFC-Object of type IfcType using createIfcEntityWithRootAttributes.
     *
     * @param entity
     * @param clazz
     * @param <IfcType>
     * @return IFC-Object of type IfcType.
     * @throws ParseToIfcException
     */
    public <IfcType extends IfcObjectDefinition> IfcType createIfcEntityWithRootAttributesTypeSave(IEntity entity, Class<IfcType> clazz)
            throws ParseToIfcException {
        IfcObjectDefinition ifcObject = createIfcEntityWithRootAttributes(entity);
        if (!clazz.isInstance(ifcObject)) {
            throw new ParseToIfcException("Internal Error in creation of type " + clazz.getSimpleName() + ".");
        }
        return clazz.cast(ifcObject);
    }

    private void addRootAttributes(IfcRoot ifcEntity, IEntity iEntity) {
        String globalId = iEntity.getGlobalId();
        String name = iEntity.getName();
        String description = iEntity.getDescription();

        ifcEntity.setGlobalId(globalId);
        ifcEntity.setName(name);
        ifcEntity.setDescription(description);
    }

    private IfcObjectDefinition createIfcEntity(IEntity iEntity)
            throws ParseToIfcException {
        if (iEntity instanceof IProject) {
            return new IfcProject();
        }
        if (iEntity instanceof ISite) {
            return new IfcSite();
        }
        if (iEntity instanceof IBuilding) {
            return new IfcBuilding();
        }
        if (iEntity instanceof IBuildingStorey) {
            return new IfcBuildingStorey();
        }
        if (iEntity instanceof IWall) {
            return new IfcWall();
        }
        if (iEntity instanceof IDoor) {
            return new IfcDoor();
        }
        if (iEntity instanceof IWindow) {
            return new IfcWindow();
        }
        if (iEntity instanceof ISpace) {
            return new IfcSpace();
        }
        if (iEntity instanceof ISanitaryTerminal) {
            return new IfcSanitaryTerminal();
        }
        if (iEntity instanceof IChimney) {
            return new IfcChimney();
        }
        if (iEntity instanceof IStair) {
            return new IfcStair();
        }
        if (iEntity instanceof ISlab) {
            return new IfcSlab();
        }
        throw new ParseToIfcException("Node " + iEntity.getClass().getSimpleName() + " has no matching IFC Type.");
    }

//    private IfcObjectDefinition createIfcEntity(IEntity iEntity)
//            throws ParseToIfcException {
//        Map<Class<? extends IEntity>, Class<? extends IfcObjectDefinition>> ifcElements = new HashMap<>();
//        ifcElements.put(IProject.class, IfcProject.class);
//        ifcElements.put(ISite.class, IfcSite.class);
//        ifcElements.put(IBuilding.class, IfcBuilding.class);
//        ifcElements.put(IBuildingStorey.class, IfcBuildingStorey.class);
//        ifcElements.put(IWall.class, IfcWall.class);
//        ifcElements.put(IWindow.class, IfcWindow.class);
//        ifcElements.put(IDoor.class, IfcDoor.class);
//        ifcElements.put(ISpace.class, IfcSpace.class);
//        ifcElements.put(ISanitaryTerminal.class, IfcSanitaryTerminal.class);
//        ifcElements.put(IChimney.class, IfcChimney.class);
//        ifcElements.put(IStair.class, IfcStair.class);
//        ifcElements.put(ISlab.class, IfcSlab.class);
//        try {
//            return ifcElements.get(iEntity.getClass()).getDeclaredConstructor().newInstance();
//        } catch (Exception e) {
//            throw new ParseToIfcException("Node " + iEntity.getClass().getSimpleName() + " has no matching IFC Type.");
//        }
//    }
}
