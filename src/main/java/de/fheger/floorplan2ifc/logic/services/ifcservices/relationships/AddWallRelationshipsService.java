package de.fheger.floorplan2ifc.logic.services.ifcservices.relationships;

import de.fheger.floorplan2ifc.gui.entityinterfaces.IWall;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWall;
import de.fheger.floorplan2ifc.models.entities.root.relationship.relconnects.IfcRelInterferesElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddWallRelationshipsService  implements IAddRelationshipsService<IfcWall, IWall> {

    private final FindIfcEntityService findIfcEntityService;

    @Autowired
    public AddWallRelationshipsService(FindIfcEntityService findIfcEntityService) {
        this.findIfcEntityService = findIfcEntityService;
    }

    @Override
    public void addRelationships(IfcWall ifcWall, IWall iEntity)
            throws ParseToIfcException {
        List<IWall> interferenceWalls = iEntity.getInterferenceWalls();
        for (IWall interferenceWall : interferenceWalls) {
            IfcWall interferenceIfcWall = findIfcEntityService.findIfcEntity(ifcWall, interferenceWall.getGlobalId(), IfcWall.class);
            IfcRelInterferesElements relInterference = new IfcRelInterferesElements(ifcWall, interferenceIfcWall);
            ifcWall.getInterferesElements().add(relInterference);
            interferenceIfcWall.getIsInterferedByElements().add(relInterference);
        }
    }
}
