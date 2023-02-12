package de.fheger.floorplan2ifc.models.placements;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Random;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
@Node
public class IfcLengthMeasure {
    @Id
    private int id = new Random().nextInt(Integer.MAX_VALUE);

    private double value;

    public IfcLengthMeasure(double value) {
        this.value = value;
    }
}
