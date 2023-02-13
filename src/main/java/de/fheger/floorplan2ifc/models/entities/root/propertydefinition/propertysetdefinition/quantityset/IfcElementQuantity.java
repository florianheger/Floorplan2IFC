package de.fheger.floorplan2ifc.models.entities.root.propertydefinition.propertysetdefinition.quantityset;

import de.fheger.floorplan2ifc.models.entities.root.propertydefinition.propertysetdefinition.IfcQuantitySet;
import de.fheger.floorplan2ifc.models.quantities.IfcPhysicalQuantity;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

@SuppressWarnings("unused")
@Node
public class IfcElementQuantity extends IfcQuantitySet {
    @Relationship(type = "Quantities")
    private final Set<IfcPhysicalQuantity> quantities;

    public IfcElementQuantity(Set<IfcPhysicalQuantity> quantities) {
        this.quantities = quantities;
    }
}
