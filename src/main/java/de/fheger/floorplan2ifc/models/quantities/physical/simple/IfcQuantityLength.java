package de.fheger.floorplan2ifc.models.quantities.physical.simple;

import de.fheger.floorplan2ifc.models.quantities.physical.IfcPhysicalSimpleQuantity;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class IfcQuantityLength extends IfcPhysicalSimpleQuantity {
    private final double lengthValue;
    private final String formula;

    public IfcQuantityLength(String name, double lengthValue, String formula) {
        this.lengthValue = lengthValue;
        this.formula = formula;
    }
}
