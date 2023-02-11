package de.fheger.floorplan2ifc.models.entities.root;
import de.fheger.floorplan2ifc.models.entities.IfcRoot;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelAggregates;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelNests;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

public abstract class IfcObjectDefinition extends IfcRoot {
    @Relationship(type = "Nests")
    @Getter
    private final Set<IfcRelNests> nests = new HashSet<>();

    @Relationship(type = "NestedBy")
    @Getter
    private final Set<IfcRelNests> isNestedBy = new HashSet<>();

    @Relationship(type = "DecomposedBy")
    @Getter
    private final Set<IfcRelAggregates> isDecomposedBy = new HashSet<>();

    @Relationship(type = "Decomposes")
    @Getter
    private final Set<IfcRelAggregates> decomposes = new HashSet<>();
}
