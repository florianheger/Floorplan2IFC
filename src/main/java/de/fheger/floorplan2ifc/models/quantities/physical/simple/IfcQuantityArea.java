package de.fheger.floorplan2ifc.models.quantities.physical.simple;

import de.fheger.floorplan2ifc.models.quantities.physical.IfcPhysicalSimpleQuantity;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class IfcQuantityArea extends IfcPhysicalSimpleQuantity {
    private final double areaValue;
    private final String formula;

    public IfcQuantityArea(String name, double areaValue, String formula) {
        setName(name);
        this.areaValue = areaValue;
        this.formula = formula;
    }
}
