package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.gui.panels.EntityPanel;
import de.fheger.floorplan2ifc.gui.panels.ProjectPanel;
import de.fheger.floorplan2ifc.gui.panels.placement.*;
import de.fheger.floorplan2ifc.gui.panels.placement.length.DoorPanel;
import de.fheger.floorplan2ifc.gui.panels.placement.length.WallPanel;
import de.fheger.floorplan2ifc.gui.panels.placement.length.WindowPanel;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.IfcRoot;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.IfcProduct;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.*;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.distributionelement.distributionflowelement.flowterminal.IfcSanitaryTerminal;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcBuildingStorey;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSite;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSpace;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.facility.IfcBuilding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

        if (entityPanel instanceof EntityPanelWithPlacement entityPanelWithPlacement) {
            addPlacementService.addPlacement((IfcProduct) ifcEntity, entityPanelWithPlacement);
        }
        return ifcEntity;
    }

    public <IfcType extends IfcObjectDefinition> IfcType createIfcEntityWithRootAttributesTypeSave(EntityPanel entityPanel, Class<IfcType> clazz)
            throws ParseToIfcException {
        IfcObjectDefinition ifcObject = createIfcEntityWithRootAttributes(entityPanel);
        if (!clazz.isInstance(ifcObject)) {
            throw new ParseToIfcException("Internal Error in creation of type " + clazz.getSimpleName() + ".");
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
        Map<Class<? extends EntityPanel>, Class<? extends IfcObjectDefinition>> ifcElements = new HashMap<>();
        ifcElements.put(ProjectPanel.class, IfcProject.class);
        ifcElements.put(SitePanel.class, IfcSite.class);
        ifcElements.put(BuildingPanel.class, IfcBuilding.class);
        ifcElements.put(BuildingStoreyPanel.class, IfcBuildingStorey.class);
        ifcElements.put(WallPanel.class, IfcWall.class);
        ifcElements.put(WindowPanel.class, IfcWindow.class);
        ifcElements.put(DoorPanel.class, IfcDoor.class);
        ifcElements.put(SpacePanel.class, IfcSpace.class);
        ifcElements.put(SanitaryTerminalPanel.class, IfcSanitaryTerminal.class);
        ifcElements.put(ChimneyPanel.class, IfcChimney.class);
        ifcElements.put(StairPanel.class, IfcStair.class);
        try {
            return ifcElements.get(entityPanel.getClass()).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new ParseToIfcException("Node " + entityPanel.getClass().getSimpleName() + " has no matching IFC Type.");
        }
    }
}
