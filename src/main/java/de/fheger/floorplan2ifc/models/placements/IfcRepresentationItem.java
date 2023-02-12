package de.fheger.floorplan2ifc.models.placements;

import org.springframework.data.neo4j.core.schema.Id;

import java.util.Random;

public abstract class IfcRepresentationItem {
    @Id
    private int id = new Random().nextInt(Integer.MAX_VALUE);
}
