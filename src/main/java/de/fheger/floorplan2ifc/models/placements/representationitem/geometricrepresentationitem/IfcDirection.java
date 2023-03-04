package de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem;

import de.fheger.floorplan2ifc.models.placements.representationitem.IfcGeometricRepresentationItem;

@SuppressWarnings("ALL")
public class IfcDirection extends IfcGeometricRepresentationItem {
    private final double directionRatio;

    public IfcDirection(double directionRatio) {
        this.directionRatio = directionRatio;
    }
}
