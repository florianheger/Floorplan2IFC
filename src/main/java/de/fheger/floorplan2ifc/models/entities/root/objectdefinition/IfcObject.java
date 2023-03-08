package de.fheger.floorplan2ifc.models.entities.root.objectdefinition;

import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldefines.IfcRelDefinesByProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

public abstract class IfcObject extends IfcObjectDefinition {
    @Relationship(type = "IsDefinedBy")
    @Getter
    private final Set<IfcRelDefinesByProperties> isDefinedBy = new HashSet<>();

    @Getter
    @Setter
    private double length;

    @Getter
    @Setter
    private double width;

    @Getter
    @Setter
    private double height;
}
