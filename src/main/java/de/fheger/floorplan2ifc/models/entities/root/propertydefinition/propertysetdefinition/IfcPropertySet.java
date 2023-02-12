package de.fheger.floorplan2ifc.models.entities.root.propertydefinition.propertysetdefinition;

import de.fheger.floorplan2ifc.models.entities.root.propertydefinition.IfcPropertySetDefinition;
import de.fheger.floorplan2ifc.models.properties.propertyabstraction.IfcProperty;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

@Node
public class IfcPropertySet extends IfcPropertySetDefinition {
    @Relationship(type = "HasProperties")
    private final Set<IfcProperty> hasProperties;

    public IfcPropertySet(Set<IfcProperty> hasProperties) {
        this.hasProperties = hasProperties;
    }
}
