package de.fheger.floorplan2ifc.models.quantities;

import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;

import java.util.Random;

@SuppressWarnings("unused")
public abstract class IfcPhysicalQuantity {
    @Id
    private int id = new Random().nextInt(Integer.MAX_VALUE);

    @Setter(AccessLevel.PROTECTED)
    private String name;
}
