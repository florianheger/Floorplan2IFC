package de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.IfcBuiltElement;
import lombok.Setter;

public class IfcNewObject extends IfcBuiltElement {
    @Setter
    private String newAttribute;
}
