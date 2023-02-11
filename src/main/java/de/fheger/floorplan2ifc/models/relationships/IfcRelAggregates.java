package de.fheger.floorplan2ifc.models.relationships;

import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

public class IfcRelAggregates {
    @Relationship(type = "RelatingObject")
    private IfcObjectDefinition relatingObject;

    @Relationship(type = "RelatedObjects")
    private final Set<IfcObjectDefinition> relatedObjects;

    public IfcRelAggregates(IfcObjectDefinition relatingObject, Set<IfcObjectDefinition> relatedObjects) {
        this.relatingObject = relatingObject;
        this.relatedObjects = relatedObjects;
    }
}
