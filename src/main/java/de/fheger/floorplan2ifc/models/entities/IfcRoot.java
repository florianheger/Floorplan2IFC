package de.fheger.floorplan2ifc.models.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;

public abstract class IfcRoot {
    @Id
    @Setter
    private String globalId;

    @Getter
    @Setter
    private String name;

    @Setter
    private String description;
}
