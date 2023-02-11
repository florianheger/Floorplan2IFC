package de.fheger.floorplan2ifc.models.helper;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.IfcProduct;
import org.springframework.data.neo4j.core.schema.Relationship;

public class IfcObjectPlacement {
    @Relationship(type = "PlacementRelTo")
    private IfcObjectPlacement placementRelTo;

    @Relationship(type = "PlacesObject")
    private IfcProduct placesObject;
}
