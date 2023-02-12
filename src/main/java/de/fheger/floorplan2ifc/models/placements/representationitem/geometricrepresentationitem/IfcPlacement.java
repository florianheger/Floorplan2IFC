package de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem;

import de.fheger.floorplan2ifc.models.placements.representationitem.IfcGeometricRepresentationItem;
import de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem.point.IfcCartesianPoint;
import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Relationship;

public abstract class IfcPlacement extends IfcGeometricRepresentationItem {
    @Relationship(type = "Location")
    @Setter(AccessLevel.PROTECTED)
    private IfcCartesianPoint location;
}
