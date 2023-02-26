package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.gui.entityinterfaces.IWall;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.IAddAttributesService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.relationships.IAddRelationshipsService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IfcWallService extends IfcService<IfcWall, IWall> {

    @Autowired
    protected IfcWallService(FindIfcEntityService findIfcEntityService, IAddAttributesService<IfcWall, IWall> addAttributes, IAddRelationshipsService<IfcWall, IWall> addRelationships) {
        super(IfcWall.class, IWall.class, findIfcEntityService, addAttributes, addRelationships);
    }
}
