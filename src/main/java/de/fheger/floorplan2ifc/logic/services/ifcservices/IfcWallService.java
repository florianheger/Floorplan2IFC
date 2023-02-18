package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.WallNode;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.AddAttributes;
import de.fheger.floorplan2ifc.logic.services.ifcservices.relationships.AddRelationships;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IfcWallService extends IfcService<IfcWall, WallNode> {

    @Autowired
    protected IfcWallService(FindIfcEntityService findIfcEntityService, AddAttributes<IfcWall, WallNode> addAttributes, AddRelationships<IfcWall, WallNode> addRelationships) {
        super(IfcWall.class, WallNode.class, findIfcEntityService, addAttributes, addRelationships);
    }
}
