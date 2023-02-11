package de.fheger.floorplan2ifc.models.quantities;

import lombok.AccessLevel;
import lombok.Setter;

public abstract class IfcPhysicalQuantity {
    @Setter(AccessLevel.PROTECTED)
    private String name;
}
