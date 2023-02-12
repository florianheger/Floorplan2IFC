package de.fheger.floorplan2ifc.models.properties.propertyabstraction.property.simpleproperty;

import de.fheger.floorplan2ifc.models.interfaces.IfcValue;
import de.fheger.floorplan2ifc.models.properties.propertyabstraction.property.IfcSimpleProperty;
import org.springframework.data.neo4j.core.schema.Relationship;

public class IfcPropertySingleValue extends IfcSimpleProperty {
    @Relationship(type = "NominalValue")
    private final IfcValue nominalValue;

    public IfcPropertySingleValue(IfcValue nominalValue) {
        this.nominalValue = nominalValue;
    }
}
