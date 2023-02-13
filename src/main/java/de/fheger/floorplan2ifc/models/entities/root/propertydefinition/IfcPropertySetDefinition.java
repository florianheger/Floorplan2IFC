package de.fheger.floorplan2ifc.models.entities.root.propertydefinition;

import de.fheger.floorplan2ifc.models.entities.root.IfcPropertyDefinition;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldefines.IfcRelDefinesByProperties;
import de.fheger.floorplan2ifc.models.interfaces.IfcPropertySetDefinitionSelect;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Relationship;

@SuppressWarnings("unused")
public abstract class IfcPropertySetDefinition extends IfcPropertyDefinition implements IfcPropertySetDefinitionSelect {
    @Relationship(type = "DefinesOccurrence")
    @Setter
    private IfcRelDefinesByProperties definesOccurrence;
}
