package de.fheger.floorplan2ifc.logic.services.ifcservices.relationships;

import de.fheger.floorplan2ifc.gui.panels.WallPanel;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWall;
import de.fheger.floorplan2ifc.models.entities.root.relationship.relconnects.IfcRelInterferesElements;

import java.util.List;

public class AddWallRelationshipsService {
    public static void addRelationships(IfcWall ifcWall, WallPanel wallPanel)
            throws ParseToIfcException {
        List<WallPanel> interferenceWalls = wallPanel.getInterfernceWalls();
        for (WallPanel interferenceWall : interferenceWalls) {
            IfcWall interferenceIfcWall = FindIfcEntityService.findIfcEntity(ifcWall, interferenceWall.getGlobalId(), IfcWall.class);
            IfcRelInterferesElements relInterference = new IfcRelInterferesElements(ifcWall, interferenceIfcWall);
            ifcWall.getInterferesElements().add(relInterference);
            interferenceIfcWall.getIsInterferedByElements().add(relInterference);
        }
    }
}
