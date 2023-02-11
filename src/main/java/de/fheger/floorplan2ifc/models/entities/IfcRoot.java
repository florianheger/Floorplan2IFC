package de.fheger.floorplan2ifc.models.entities;

import lombok.Getter;
import lombok.Setter;
import nl.tue.isbe.ifcspftools.GuidHandler;
import org.springframework.data.neo4j.core.schema.Id;

public abstract class IfcRoot {
    @Id
    @Setter
    private String globalId = GuidHandler.getNewIfcGloballyUniqueId();

    @Getter
    @Setter
    private String name;

    @Setter
    private String description;
}
