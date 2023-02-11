package de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.featureelement;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.IfcFeatureElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelVoidsElement;
import de.fheger.floorplan2ifc.models.relationships.IfcRelNests;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

public abstract class IfcFeatureElementSubtraction extends IfcFeatureElement {
    @Relationship(type = "VoidsElements")
    @Getter
    private final Set<IfcRelVoidsElement> voidsElements = new HashSet<>();
}
