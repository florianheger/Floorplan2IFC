package de.fheger.floorplan2ifc.models.relationships;

import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

public class IfcRelNests {
    @Relationship(type = "RelatingObject")
    private final IfcObjectDefinition relatingObject;

    @Relationship(type = "RelatedObjects")
    private final Set<IfcObjectDefinition> relatedObjects;

    public IfcRelNests(IfcObjectDefinition relatingObject, Set<IfcObjectDefinition> relatedObjects) {
        this.relatingObject = relatingObject;
        this.relatedObjects = relatedObjects;
    }
}
