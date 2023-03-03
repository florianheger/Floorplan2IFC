package de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem.placement;

import de.fheger.floorplan2ifc.models.interfaces.IfcAxis2Placement;
import de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem.IfcDirection;
import de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem.IfcPlacement;
import de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem.point.IfcCartesianPoint;
import lombok.Setter;

public class IfcAxis2Placement3D extends IfcPlacement implements IfcAxis2Placement {

    @SuppressWarnings("unused")
    @Setter
    private IfcDirection axis;

    public IfcAxis2Placement3D(IfcCartesianPoint location) {
        setLocation(location);
    }
}
