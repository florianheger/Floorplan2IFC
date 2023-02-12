package de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem.placement;

import de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem.IfcPlacement;
import de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem.point.IfcCartesianPoint;

public class IfcAxis2Placement2D extends IfcPlacement implements IfcAxis2Placement {
    public IfcAxis2Placement2D(IfcCartesianPoint location) {
        setLocation(location);
    }
}
