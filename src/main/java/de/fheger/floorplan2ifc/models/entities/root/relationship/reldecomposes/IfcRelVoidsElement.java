package de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.IfcElement;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.featureelement.IfcFeatureElementSubtraction;
import de.fheger.floorplan2ifc.models.entities.root.relationship.IfcRelDecomposes;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Relationship;

@SuppressWarnings({"unused"})
public class IfcRelVoidsElement extends IfcRelDecomposes {
    @Relationship(type = "RelatingBuildingElement")
    @Getter
    private final IfcElement relatingBuildingElement;

    @Relationship(type = "RelatedOpeningElement")
    @Getter
    private final IfcFeatureElementSubtraction relatedOpeningElement;

    public IfcRelVoidsElement(IfcElement relatingBuildingElement, IfcFeatureElementSubtraction relatedOpeningElement) {
        this.relatingBuildingElement = relatingBuildingElement;
        this.relatedOpeningElement = relatedOpeningElement;
    }
}
