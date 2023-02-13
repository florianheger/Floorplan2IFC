package de.fheger.floorplan2ifc.logic.services.ifcservices.relationships;

import de.fheger.floorplan2ifc.gui.nodes.DoorNode;
import de.fheger.floorplan2ifc.gui.panels.SpacePanel;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcDoor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddDoorRelationshipsService implements AddRelationships<IfcDoor, DoorNode> {
    @Override
    public void addRelationships(IfcDoor ifcEntity, DoorNode entityNode) throws ParseToIfcException {
        List<SpacePanel> connectedSpaces = entityNode.getElementPanel().getConnectedSpaces();
        if (connectedSpaces.size() == 0 || connectedSpaces.size() > 2) {
            throw new ParseToIfcException(ifcEntity.getName() + " connects 0 or more than 2 spaces.");
        }

    }
}
