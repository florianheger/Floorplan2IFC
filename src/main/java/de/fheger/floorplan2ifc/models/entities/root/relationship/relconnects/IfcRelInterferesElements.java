package de.fheger.floorplan2ifc.models.entities.root.relationship.relconnects;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.IfcElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.IfcRelConnects;
import org.springframework.data.neo4j.core.schema.Relationship;

@SuppressWarnings({"unused"})
public class IfcRelInterferesElements extends IfcRelConnects {
    @Relationship(type = "RelatingElement")
    private final IfcElement relatingElement;

    @Relationship(type = "RelatedElement")
    private final IfcElement relatedElement;

    public IfcRelInterferesElements(IfcElement relatingElement, IfcElement relatedElement) {
        this.relatingElement = relatingElement;
        this.relatedElement = relatedElement;
    }
}
