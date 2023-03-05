package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.interfaces.IPlacement;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.IAddAttributesService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.relationships.IAddRelationshipsService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.IfcProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlacementService extends IfcService<IfcProduct, IPlacement> {
    @Autowired
    protected PlacementService(FindIfcEntityService findIfcEntityService, IAddAttributesService<IfcProduct, IPlacement> addAttributesService, IAddRelationshipsService<IfcProduct, IPlacement> addRelationshipsService) {
        super(IfcProduct.class, IPlacement.class, findIfcEntityService, addAttributesService, addRelationshipsService);
    }
}
