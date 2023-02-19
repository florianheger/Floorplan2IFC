package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.gui.panels.EntityPanel;
import de.fheger.floorplan2ifc.gui.panels.*;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.IfcRoot;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.IfcProduct;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcChimney;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcDoor;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWall;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWindow;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.distributionelement.distributionflowelement.flowterminal.IfcSanitaryTerminal;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcBuildingStorey;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSite;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSpace;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.facility.IfcBuilding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateIfcEntityWithRootAttributesService {

    private final AddPlacementService addPlacementService;

    @Autowired
    public CreateIfcEntityWithRootAttributesService(AddPlacementService addPlacementService) {
        this.addPlacementService = addPlacementService;
    }

    public IfcObjectDefinition createIfcEntityWithRootAttributes(EntityPanel entityPanel)
            throws ParseToIfcException {
        IfcObjectDefinition ifcEntity = createIfcEntity(entityPanel);
        addRootAttributes(ifcEntity, entityPanel);

        if (ifcEntity instanceof IfcProject) {
            return ifcEntity;
        }
        if (entityPanel instanceof EntityPanelWithPlacement entityPanelWithPlacement) {
            addPlacementService.addPlacement((IfcProduct) ifcEntity, entityPanelWithPlacement);
        }
        return ifcEntity;
    }

    public <IfcType extends IfcObjectDefinition> IfcType createIfcEntityWithRootAttributesTypeSave(EntityPanel entityPanel, Class<IfcType> clazz)
            throws ParseToIfcException {
        IfcObjectDefinition ifcObject = createIfcEntityWithRootAttributes(entityPanel);
        if (!clazz.isInstance(ifcObject)) {
            throw new ParseToIfcException("Internal Error in creation of type" + clazz.getSimpleName() + ".");
        }
        return clazz.cast(ifcObject);
    }

    private void addRootAttributes(IfcRoot ifcEntity, EntityPanel entityPanel) {
        String globalId = entityPanel.getGlobalId();
        String name = entityPanel.getName();
        String description = entityPanel.getDescription();

        ifcEntity.setGlobalId(globalId);
        ifcEntity.setName(name);
        ifcEntity.setDescription(description);
    }

    private IfcObjectDefinition createIfcEntity(EntityPanel entityPanel)
            throws ParseToIfcException {
        if (entityPanel instanceof ProjectPanel) {
            return new IfcProject();
        }
        if (entityPanel instanceof SitePanel) {
            return new IfcSite();
        }
        if (entityPanel instanceof BuildingPanel) {
            return new IfcBuilding();
        }
        if (entityPanel instanceof BuildingStoreyPanel) {
            return new IfcBuildingStorey();
        }
        if (entityPanel instanceof WallPanel) {
            return new IfcWall();
        }
        if (entityPanel instanceof WindowPanel) {
            return new IfcWindow();
        }
        if (entityPanel instanceof DoorPanel) {
            return new IfcDoor();
        }
        if (entityPanel instanceof SpacePanel) {
            return new IfcSpace();
        }
        if (entityPanel instanceof SanitaryTerminalPanel) {
            return new IfcSanitaryTerminal();
        }
        if (entityPanel instanceof ChimneyPanel) {
            return new IfcChimney();
        }
        throw new ParseToIfcException("Node " + entityPanel.getClass().getSimpleName() + " has no matching IFC Type.");
    }
}
