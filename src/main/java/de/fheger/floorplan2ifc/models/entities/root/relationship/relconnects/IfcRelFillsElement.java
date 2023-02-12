package de.fheger.floorplan2ifc.models.entities.root.relationship.relconnects;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.IfcElement;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.featureelement.featureelementsubtraction.IfcOpeningElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.IfcRelConnects;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class IfcRelFillsElement extends IfcRelConnects {
    @Relationship(type = "RelatingOpeningElement")
    @Getter
    private final IfcOpeningElement relatingOpeningElement;

    @Relationship(type = "RelatedBuildingElement")
    private final IfcElement relatedBuildingElement;

    public IfcRelFillsElement(IfcOpeningElement relatingOpeningElement, IfcElement relatedBuildingElement) {
        this.relatingOpeningElement = relatingOpeningElement;
        this.relatedBuildingElement = relatedBuildingElement;
    }
}
