package de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.IfcElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.IfcRelConnects;
import de.fheger.floorplan2ifc.models.interfaces.IfcSpaceBoundarySelect;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class IfcRelSpaceBoundary extends IfcRelConnects {
    @Relationship(type = "RelatingSpace")
    private final IfcSpaceBoundarySelect relatingSpace;

    @Relationship(type = "RelatedBuildingElement")
    private final IfcElement relatedBuildingElement;

    public IfcRelSpaceBoundary(IfcSpaceBoundarySelect relatingSpace, IfcElement relatedBuildingElement) {
        this.relatingSpace = relatingSpace;
        this.relatedBuildingElement = relatedBuildingElement;
    }
}
