package de.fheger.floorplan2ifc.models.entities.root.propertydefinition.propertysetdefinition.quantityset;

import de.fheger.floorplan2ifc.models.entities.root.propertydefinition.propertysetdefinition.IfcQuantitySet;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

@SuppressWarnings("ALL")
public class IfcElementQuantity extends IfcQuantitySet {
    @Relationship(type = "Quantities")
    private final Set<IfcPhysicalQuantity> quantities;

    public IfcElementQuantity(Set<IfcPhysicalQuantity> quantities) {
        this.quantities = quantities;
    }
}
