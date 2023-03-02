package de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.IfcBuiltElement;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class IfcNewObject extends IfcBuiltElement {
    @Setter
    private String newAttribute;
}
