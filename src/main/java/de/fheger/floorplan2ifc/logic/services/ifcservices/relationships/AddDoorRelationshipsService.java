package de.fheger.floorplan2ifc.logic.services.ifcservices.relationships;

import de.fheger.floorplan2ifc.gui.nodes.DoorNode;
import de.fheger.floorplan2ifc.gui.panels.SpacePanel;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcDoor;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSpace;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelNests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class AddDoorRelationshipsService implements AddRelationships<IfcDoor, DoorNode> {

    private final FindIfcEntityService findIfcEntityService;

    @Autowired
    public AddDoorRelationshipsService(FindIfcEntityService findIfcEntityService) {
        this.findIfcEntityService = findIfcEntityService;
    }

    @Override
    public void addRelationships(IfcDoor ifcEntity, DoorNode entityNode) throws ParseToIfcException {
        List<SpacePanel> connectedSpaces = entityNode.getElementPanel().getConnectedSpaces();
        if (connectedSpaces.size() == 0 || connectedSpaces.size() > 2) {
            throw new ParseToIfcException(ifcEntity.getName() + " connects 0 or more than 2 spaces.");
        }
        List<IfcSpace> connectedIfcSpaces = new ArrayList<>();
        for (SpacePanel connectedSpace : connectedSpaces) {
            connectedIfcSpaces.add(findIfcEntityService.findIfcEntity(ifcEntity, connectedSpace.getGlobalId(), IfcSpace.class));
        }
        IfcRelNests relDoorSpaces = new IfcRelNests(ifcEntity, new HashSet<>(connectedIfcSpaces));
        ifcEntity.getNests().add(relDoorSpaces);
        connectedIfcSpaces.forEach(space -> space.getIsNestedBy().add(relDoorSpaces));
    }
}
