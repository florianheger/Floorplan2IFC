package de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem.point;

import de.fheger.floorplan2ifc.models.placements.IfcLengthMeasure;
import de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem.IfcPoint;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class IfcCartesianPoint extends IfcPoint {
    @Relationship(type = "Coordinates")
    private final Set<IfcLengthMeasure> coordinates;

    public IfcCartesianPoint(Set<IfcLengthMeasure> coordinates) {
        this.coordinates = coordinates;
    }
}
