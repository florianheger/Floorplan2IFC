package de.fheger.floorplan2ifc.logic.services.ifcservices.relationships;

import de.fheger.floorplan2ifc.interfaces.IPlacement;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.IfcProduct;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.IfcElement;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcDoor;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWindow;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcBuildingStorey;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSite;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.facility.IfcBuilding;
import org.springframework.stereotype.Service;

@Service
public class AddRelativePlacement implements IAddRelationshipsService<IfcProduct, IPlacement> {
    @Override
    public void addRelationships(IfcProduct ifcEntity, IPlacement iEntity) throws ParseToIfcException {
        if (ifcEntity instanceof IfcSite) {
            return;
        }
        if (ifcEntity instanceof IfcBuilding || ifcEntity instanceof IfcBuildingStorey) {
            setPlacementRelToParent(ifcEntity);
            return;
        }
        setPlacementRelToStorey(ifcEntity, ifcEntity);
    }

    /**
     * Add Relative Placement between placementToAdd and relating IfcBuildingSorey
     *
     * @param placementToAdd IfcProduct to add the relative placement.
     * @param child          for recursive calls. Is the same as placementToAdd in the first call.
     */
    private void setPlacementRelToStorey(IfcProduct placementToAdd, IfcProduct child) {
        IfcProduct parent = getParent(child);
        if (parent instanceof IfcBuildingStorey) {
            setPlacementRelToParent(placementToAdd);
            return;
        }
        setPlacementRelToStorey(placementToAdd, parent);
    }

    private void setPlacementRelToParent(IfcProduct child) {
        child.getObjectPlacement().setPlacementRelTo(getParent(child).getObjectPlacement());
    }

    private IfcProduct getParent(IfcProduct child) {
        if (child instanceof IfcDoor || child instanceof IfcWindow) {
            IfcElement ifcElement = (IfcElement) child;
            return ifcElement.getFillsVoids().iterator().next()
                    .getRelatingOpeningElement().getVoidsElements()
                    .iterator().next().getRelatingBuildingElement();
        }
        return (IfcProduct) child.getDecomposes().iterator().next().getRelatingObject();
    }
}
