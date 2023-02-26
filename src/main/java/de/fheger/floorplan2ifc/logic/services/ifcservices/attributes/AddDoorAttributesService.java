package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.interfaces.IDoor;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcDoor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddDoorAttributesService implements IAddAttributesService<IfcDoor, IDoor> {

    private final AddLengthToOpeningElement addLengthToOpeningElement;

    @Autowired
    public AddDoorAttributesService(AddLengthToOpeningElement addLengthToOpeningElement) {
        this.addLengthToOpeningElement = addLengthToOpeningElement;
    }

    @Override
    public void addAttributes(IfcDoor ifcEntity, IDoor iEntity) throws ParseToIfcException {
        addLengthToOpeningElement.addLengthToOpeningElement(iEntity.getEntityLength(), ifcEntity);
    }
}
