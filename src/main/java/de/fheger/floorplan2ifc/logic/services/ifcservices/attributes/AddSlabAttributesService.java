package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.interfaces.ISlab;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcSlab;
import de.fheger.floorplan2ifc.models.enums.IfcSlabTypeEnum;
import org.springframework.stereotype.Service;

@Service
public class AddSlabAttributesService implements IAddAttributesService<IfcSlab, ISlab> {
    @Override
    public void addAttributes(IfcSlab ifcEntity, ISlab iEntity) throws ParseToIfcException {
        ifcEntity.setPredefinedType(IfcSlabTypeEnum.FLOOR);
    }
}
