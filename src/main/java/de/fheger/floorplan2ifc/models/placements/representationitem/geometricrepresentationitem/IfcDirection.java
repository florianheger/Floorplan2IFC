package de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem;

import de.fheger.floorplan2ifc.models.placements.representationitem.IfcGeometricRepresentationItem;
import org.springframework.data.neo4j.core.schema.Node;

@SuppressWarnings("ALL")
@Node
public class IfcDirection extends IfcGeometricRepresentationItem {
    private final double directionRatio;

    public IfcDirection(double directionRatio) {
        this.directionRatio = directionRatio;
    }
}
