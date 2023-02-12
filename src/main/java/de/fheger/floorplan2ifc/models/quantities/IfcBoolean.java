package de.fheger.floorplan2ifc.models.quantities;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Random;

@Node
public class IfcBoolean {
    @Id
    private int id = new Random().nextInt(Integer.MAX_VALUE);

    private boolean value;

    public IfcBoolean(boolean value) {
        this.value = value;
    }
}
