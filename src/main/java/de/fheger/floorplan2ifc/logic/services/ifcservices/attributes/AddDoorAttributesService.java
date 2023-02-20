package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.gui.nodes.DoorNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcDoor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddDoorAttributesService implements IAddAttributesService<IfcDoor, DoorNode> {

    private final AddLengthToOpeningElement addLengthToOpeningElement;

    @Autowired
    public AddDoorAttributesService(AddLengthToOpeningElement addLengthToOpeningElement) {
        this.addLengthToOpeningElement = addLengthToOpeningElement;
    }

    @Override
    public void addAttributes(IfcDoor ifcEntity, DoorNode entityNode) throws ParseToIfcException {
        addLengthToOpeningElement.addLengthToOpeningElement(entityNode.getEntityPanel().getEntityWidth(), ifcEntity);
    }
}
