package de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.IfcObject;
import de.fheger.floorplan2ifc.models.placements.IfcObjectPlacement;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Relationship;

@SuppressWarnings("unused")
public abstract class IfcProduct extends IfcObject {
    @Relationship(type = "ObjectPlacement")
    @Getter
    @Setter
    private IfcObjectPlacement objectPlacement;
}
