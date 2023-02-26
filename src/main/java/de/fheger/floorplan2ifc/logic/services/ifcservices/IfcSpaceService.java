package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.gui.entityinterfaces.ISpace;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.IAddAttributesService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.relationships.IAddRelationshipsService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IfcSpaceService extends IfcService<IfcSpace, ISpace> {
    @Autowired
    protected IfcSpaceService(FindIfcEntityService findIfcEntityService, IAddAttributesService<IfcSpace, ISpace> addAttributes, IAddRelationshipsService<IfcSpace, ISpace> addRelationships) {
        super(IfcSpace.class, ISpace.class, findIfcEntityService, addAttributes, addRelationships);
    }
}
