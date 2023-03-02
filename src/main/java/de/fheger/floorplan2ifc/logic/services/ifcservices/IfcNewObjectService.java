package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.interfaces.INewObject;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.IAddAttributesService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcNewObject;

public class IfcNewObjectService extends IfcService<IfcNewObject, INewObject> {
    protected IfcNewObjectService(FindIfcEntityService findIfcEntityService, IAddAttributesService<IfcNewObject, INewObject> addAttributesService) {
        super(IfcNewObject.class, INewObject.class, findIfcEntityService, addAttributesService);
    }
}
