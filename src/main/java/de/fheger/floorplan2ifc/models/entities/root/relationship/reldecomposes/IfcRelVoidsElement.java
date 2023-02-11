package de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.IfcElement;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.featureelement.IfcFeatureElementSubtraction;
import de.fheger.floorplan2ifc.models.entities.root.relationship.IfcRelDecomposes;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class IfcRelVoidsElement extends IfcRelDecomposes {
    @Relationship(type = "RelatingBuildingElement")
    private IfcElement relatingBuildingElement;

    @Relationship(type = "RelatedOpeningElement")
    private IfcFeatureElementSubtraction relatedOpeningElement;

    public IfcRelVoidsElement(IfcElement relatingBuildingElement, IfcFeatureElementSubtraction relatedOpeningElement) {
        this.relatingBuildingElement = relatingBuildingElement;
        this.relatedOpeningElement = relatedOpeningElement;
    }
}
