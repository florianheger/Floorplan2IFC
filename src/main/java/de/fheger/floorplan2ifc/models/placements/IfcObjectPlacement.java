package de.fheger.floorplan2ifc.models.placements;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.IfcProduct;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Random;

@SuppressWarnings("unused")
public abstract class IfcObjectPlacement {
    @Id
    private int id = new Random().nextInt(Integer.MAX_VALUE);

    @Relationship(type = "PlacementRelTo")
    private IfcObjectPlacement placementRelTo;

    @Relationship(type = "PlacesObject")
    private IfcProduct placesObject;
}
