package de.fheger.floorplan2ifc.models.quantities.physical.simple;

import de.fheger.floorplan2ifc.models.quantities.physical.IfcPhysicalSimpleQuantity;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class IfcQuantityLength extends IfcPhysicalSimpleQuantity {
    private final double lengthValue;
    private final String formula;

    public IfcQuantityLength(String name, double lengthValue, String formula) {
        setName(name);
        this.lengthValue = lengthValue;
        this.formula = formula;
    }
}
