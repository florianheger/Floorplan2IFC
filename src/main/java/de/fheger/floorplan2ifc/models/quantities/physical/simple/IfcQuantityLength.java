package de.fheger.floorplan2ifc.models.quantities.physical.simple;

import de.fheger.floorplan2ifc.models.quantities.physical.IfcPhysicalSimpleQuantity;
import lombok.Setter;

public class IfcQuantityLength extends IfcPhysicalSimpleQuantity {
    private double lengthValue;
    private String formula;

    public IfcQuantityLength(String name, double lengthValue, String formula) {
        this.lengthValue = lengthValue;
        this.formula = formula;
    }
}
