package de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.IfcBuiltElement;
import lombok.Getter;
import lombok.Setter;

public class IfcWall extends IfcBuiltElement {
    @Getter
    @Setter
    private boolean isBearing;

    @Getter
    @Setter
    private boolean isExternal;
}
