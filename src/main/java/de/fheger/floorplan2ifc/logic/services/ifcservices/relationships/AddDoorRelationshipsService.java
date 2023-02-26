package de.fheger.floorplan2ifc.logic.services.ifcservices.relationships;

import de.fheger.floorplan2ifc.gui.entityinterfaces.IDoor;
import de.fheger.floorplan2ifc.gui.entityinterfaces.ISpace;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcDoor;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSpace;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelSpaceBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddDoorRelationshipsService implements IAddRelationshipsService<IfcDoor, IDoor> {

    private final FindIfcEntityService findIfcEntityService;

    @Autowired
    public AddDoorRelationshipsService(FindIfcEntityService findIfcEntityService) {
        this.findIfcEntityService = findIfcEntityService;
    }

    @Override
    public void addRelationships(IfcDoor ifcEntity, IDoor iEntity) throws ParseToIfcException {
        List<ISpace> connectedSpaces = iEntity.getConnectedSpaces();
        if (connectedSpaces.size() == 0 || connectedSpaces.size() > 2) {
            throw new ParseToIfcException(ifcEntity.getName() + " connects " + connectedSpaces.size() + " spaces. Should be 1 for external and 2 for internal doors.");
        }
        for (ISpace connectedSpace : connectedSpaces) {
            IfcSpace connectedIfcSpaces = findIfcEntityService.findIfcEntity(ifcEntity, connectedSpace.getGlobalId(), IfcSpace.class);
            IfcRelSpaceBoundary relDoorSpace = new IfcRelSpaceBoundary(connectedIfcSpaces, ifcEntity);
            connectedIfcSpaces.getBoundedBy().add(relDoorSpace);
            ifcEntity.getProvidesBoundaries().add(relDoorSpace);
        }
    }
}
