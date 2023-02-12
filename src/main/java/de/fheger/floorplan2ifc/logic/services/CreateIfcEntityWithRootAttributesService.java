package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.gui.ElementPanel;
import de.fheger.floorplan2ifc.gui.panels.*;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.IfcRoot;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.IfcProduct;
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

    public IfcObjectDefinition createIfcEntityWithRootAttributes(ElementPanel elementPanel)
            throws ParseToIfcException {
        IfcObjectDefinition ifcEntity = createIfcEntity(elementPanel);
        addRootAttributes(ifcEntity, elementPanel);

        if (ifcEntity instanceof IfcProject) {
            return ifcEntity;
        }
        addPlacementService.addPlacement((IfcProduct) ifcEntity, elementPanel);
        return ifcEntity;
    }

    public <IfcType extends IfcObjectDefinition> IfcType createIfcEntityWithRootAttributesTypeSave(ElementPanel elementPanel, Class<IfcType> clazz)
            throws ParseToIfcException {
        IfcObjectDefinition ifcObject = createIfcEntityWithRootAttributes(elementPanel);
        if (!clazz.isInstance(ifcObject)) {
            throw new ParseToIfcException("Internal Error in creation of type" + clazz.getSimpleName() + ".");
        }
        return clazz.cast(ifcObject);
    }

    private void addRootAttributes(IfcRoot ifcEntity, ElementPanel elementPanel) {
        String globalId = elementPanel.getGlobalId();
        String name = elementPanel.getName();
        String description = elementPanel.getDescription();

        ifcEntity.setGlobalId(globalId);
        ifcEntity.setName(name);
        ifcEntity.setDescription(description);
    }

    private IfcObjectDefinition createIfcEntity(ElementPanel elementPanel)
            throws ParseToIfcException {
        if (elementPanel instanceof ProjectPanel) {
            return new IfcProject();
        }
        if (elementPanel instanceof SitePanel) {
            return new IfcSite();
        }
        if (elementPanel instanceof BuildingPanel) {
            return new IfcBuilding();
        }
        if (elementPanel instanceof BuildingStoreyPanel) {
            return new IfcBuildingStorey();
        }
        if (elementPanel instanceof WallPanel) {
            return new IfcWall();
        }
        if (elementPanel instanceof WindowPanel) {
            return new IfcWindow();
        }
        if (elementPanel instanceof DoorPanel) {
            return new IfcDoor();
        }
        if (elementPanel instanceof SpacePanel) {
            return new IfcSpace();
        }
        if (elementPanel instanceof SanitaryTerminalPanel) {
            return new IfcSanitaryTerminal();
        }
        throw new ParseToIfcException("Node " + elementPanel.getClass().getSimpleName() + " has no matching IFC Type.");
    }
}
