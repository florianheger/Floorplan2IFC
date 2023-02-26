package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.interfaces.IDoor;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.IAddAttributesService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.relationships.IAddRelationshipsService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcDoor;
import org.springframework.stereotype.Service;

@Service
public class IfcDoorService extends IfcService<IfcDoor, IDoor> {
    protected IfcDoorService(FindIfcEntityService findIfcEntityService, IAddAttributesService<IfcDoor, IDoor> addAttributes, IAddRelationshipsService<IfcDoor, IDoor> addRelationships) {
        super(IfcDoor.class, IDoor.class, findIfcEntityService, addAttributes, addRelationships);
    }
}
