package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.interfaces.IPlacement;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.IfcProduct;
import de.fheger.floorplan2ifc.models.placements.IfcObjectPlacement;
import de.fheger.floorplan2ifc.models.placements.objectplacement.IfcLocalPlacement;
import org.springframework.stereotype.Service;

@Service
public class AddPlacementAttributesService implements IAddAttributesService<IfcProduct, IPlacement> {
    @Override
    public void addAttributes(IfcProduct ifcEntity, IPlacement iEntity) throws ParseToIfcException {
        double posX = iEntity.getPositionX();
        double posY = iEntity.getPositionY();
        double posZ = iEntity.getPositionZ();
        IfcObjectPlacement objectPlacement = new IfcLocalPlacement(posX, posY, posZ);
        ifcEntity.setObjectPlacement(objectPlacement);
    }
}
