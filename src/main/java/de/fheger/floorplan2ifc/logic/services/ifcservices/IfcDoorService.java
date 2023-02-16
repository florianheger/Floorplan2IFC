package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.gui.nodes.DoorNode;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.AddAttributes;
import de.fheger.floorplan2ifc.logic.services.ifcservices.relationships.AddRelationships;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcDoor;
import org.springframework.stereotype.Service;

@Service
public class IfcDoorService extends IfcService<IfcDoor, DoorNode> {
    protected IfcDoorService(FindIfcEntityService findIfcEntityService, AddAttributes<IfcDoor, DoorNode> addAttributes, AddRelationships<IfcDoor, DoorNode> addRelationships) {
        super(IfcDoor.class, DoorNode.class, findIfcEntityService, addAttributes, addRelationships);
    }
}