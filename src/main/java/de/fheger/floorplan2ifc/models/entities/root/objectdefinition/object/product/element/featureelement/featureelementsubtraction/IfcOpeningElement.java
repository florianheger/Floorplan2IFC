package de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.featureelement.featureelementsubtraction;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.featureelement.IfcFeatureElementSubtraction;
import de.fheger.floorplan2ifc.models.entities.root.relationship.relconnects.IfcRelFillsElement;
import de.fheger.floorplan2ifc.models.enums.IfcOpeningElementTypeEnum;
import de.fheger.floorplan2ifc.models.relationships.IfcRelNests;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node
public class IfcOpeningElement extends IfcFeatureElementSubtraction {
    @Setter
    private IfcOpeningElementTypeEnum predefinedType;

    @Relationship(type = "HasFillings")
    @Getter
    private final Set<IfcRelFillsElement> hasFillings = new HashSet<>();
}
