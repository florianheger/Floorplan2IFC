package de.fheger.floorplan2ifc.models.entities.root.relationship.relconnects;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.IfcElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.IfcRelConnects;
import org.springframework.data.neo4j.core.schema.Relationship;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class IfcRelInterferesElements extends IfcRelConnects {
    @Relationship(type = "RelatingElement")
    private IfcElement relatingElement;

    @Relationship(type = "RelatedElement")
    private IfcElement relatedElement;

    public IfcRelInterferesElements(IfcElement relatingElement, IfcElement relatedElement) {
        this.relatingElement = relatingElement;
        this.relatedElement = relatedElement;
    }
}
