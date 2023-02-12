package de.fheger.floorplan2ifc.models.quantities;

import de.fheger.floorplan2ifc.models.interfaces.IfcValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Random;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
@Node
public class IfcBoolean implements IfcValue {
    @Id
    private int id = new Random().nextInt(Integer.MAX_VALUE);

    private final boolean value;

    public IfcBoolean(boolean value) {
        this.value = value;
    }
}
