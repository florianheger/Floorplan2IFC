package de.fheger.floorplan2ifc.models.placements.objectplacement;

import de.fheger.floorplan2ifc.models.interfaces.IfcAxis2Placement;
import de.fheger.floorplan2ifc.models.placements.IfcObjectPlacement;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Relationship;

@SuppressWarnings("ALL")
public class IfcLocalPlacement extends IfcObjectPlacement {
    @Relationship(type = "RelativePlacement")
    @Getter
    private final IfcAxis2Placement relativePlacement;

    public IfcLocalPlacement(IfcAxis2Placement relativePlacement) {
        this.relativePlacement = relativePlacement;
    }
}
