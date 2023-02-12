package de.fheger.floorplan2ifc.models.placements.objectplacement;

import de.fheger.floorplan2ifc.models.placements.IfcObjectPlacement;
import de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem.placement.IfcAxis2Placement;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
@Node
public class IfcLocalPlacement extends IfcObjectPlacement {
    @Relationship(type = "RelativePlacement")
    private final IfcAxis2Placement relativePlacement;

    public IfcLocalPlacement(IfcAxis2Placement relativePlacement) {
        this.relativePlacement = relativePlacement;
    }
}
