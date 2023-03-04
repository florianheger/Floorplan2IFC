package de.fheger.floorplan2ifc.models.properties;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Random;

@Node
public abstract class IfcPropertyAbstraction {
    @Id
    private int id = new Random().nextInt(Integer.MAX_VALUE);
}
