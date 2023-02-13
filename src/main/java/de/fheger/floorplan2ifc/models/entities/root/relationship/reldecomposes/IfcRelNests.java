package de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes;

import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.relationship.IfcRelDecomposes;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

@SuppressWarnings({"unused"})
@Node
public class IfcRelNests extends IfcRelDecomposes {
    @Relationship(type = "RelatingObject")
    @Getter
    private final IfcObjectDefinition relatingObject;

    @Relationship(type = "RelatedObjects")
    private final Set<IfcObjectDefinition> relatedObjects;

    public IfcRelNests(IfcObjectDefinition relatingObject, Set<IfcObjectDefinition> relatedObjects) {
        this.relatingObject = relatingObject;
        this.relatedObjects = relatedObjects;
    }
}
