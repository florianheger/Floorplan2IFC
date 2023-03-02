package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.interfaces.INewObject;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcNewObject;
import org.springframework.stereotype.Service;

@Service
public class AddNewObjectAttributesService implements IAddAttributesService<IfcNewObject, INewObject> {
    @Override
    public void addAttributes(IfcNewObject ifcEntity, INewObject entityNode) throws ParseToIfcException {
        ifcEntity.setNewAttribute(entityNode.getNewAttribute());
    }
}
