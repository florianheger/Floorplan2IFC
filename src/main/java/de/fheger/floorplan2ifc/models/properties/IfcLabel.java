package de.fheger.floorplan2ifc.models.properties;

import de.fheger.floorplan2ifc.models.interfaces.IfcValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Random;

@SuppressWarnings("ALL")
@Node
public class IfcLabel implements IfcValue {
    @Id
    private int id = new Random().nextInt(Integer.MAX_VALUE);

    private final String value;

    public IfcLabel(String value) {
        this.value = value;
    }
}
