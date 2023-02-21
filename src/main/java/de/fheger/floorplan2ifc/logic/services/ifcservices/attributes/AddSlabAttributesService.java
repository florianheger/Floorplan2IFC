package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.gui.nodes.SlabNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcSlab;
import de.fheger.floorplan2ifc.models.enums.IfcSlabTypeEnum;
import org.springframework.stereotype.Service;

@Service
public class AddSlabAttributesService implements IAddAttributesService<IfcSlab, SlabNode> {
    @Override
    public void addAttributes(IfcSlab ifcEntity, SlabNode entityNode) throws ParseToIfcException {
        ifcEntity.setPredefinedType(IfcSlabTypeEnum.FLOOR);
    }
}
