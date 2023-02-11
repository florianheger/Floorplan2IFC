package de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.IfcObject;
import de.fheger.floorplan2ifc.models.helper.IfcObjectPlacement;
import org.springframework.data.neo4j.core.schema.Relationship;

public abstract class IfcProduct extends IfcObject {
    @Relationship(type = "ObjectPlacement")
    private IfcObjectPlacement objectPlacement;
}
