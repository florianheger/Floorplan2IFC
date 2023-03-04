package de.fheger.floorplan2ifc.models.placements;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Random;

@Node
public abstract class IfcRepresentationItem {
    @Id
    private int id = new Random().nextInt(Integer.MAX_VALUE);
}
