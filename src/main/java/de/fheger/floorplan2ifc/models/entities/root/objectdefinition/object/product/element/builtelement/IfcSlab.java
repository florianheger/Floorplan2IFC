package de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.IfcBuiltElement;
import de.fheger.floorplan2ifc.models.enums.IfcSlabTypeEnum;
import lombok.Setter;

@SuppressWarnings("ALL")
public class IfcSlab extends IfcBuiltElement {
    @Setter
    private IfcSlabTypeEnum predefinedType;
}
