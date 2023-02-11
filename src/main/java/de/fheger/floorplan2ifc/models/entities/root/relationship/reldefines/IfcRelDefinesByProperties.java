package de.fheger.floorplan2ifc.models.entities.root.relationship.reldefines;

import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.relationship.IfcRelDefines;
import de.fheger.floorplan2ifc.models.interfaces.IfcPropertySetDefinitionSelect;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node
public class IfcRelDefinesByProperties extends IfcRelDefines {
    @Relationship(type = "RelatedObjects")
    private final Set<IfcObjectDefinition> relatedObjects;

    @Relationship(type = "RelatingPropertyDefinition")
    private IfcPropertySetDefinitionSelect relatingPropertyDefinition;

    public IfcRelDefinesByProperties(Set<IfcObjectDefinition> relatedObjects, IfcPropertySetDefinitionSelect relatingPropertyDefinition) {
        this.relatedObjects = relatedObjects;
        this.relatingPropertyDefinition = relatingPropertyDefinition;
    }
}
