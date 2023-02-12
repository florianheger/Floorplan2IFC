package de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.IfcSpatialStructureElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelSpaceBoundary;
import de.fheger.floorplan2ifc.models.interfaces.IfcSpaceBoundarySelect;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

public class IfcSpace extends IfcSpatialStructureElement implements IfcSpaceBoundarySelect {
    @Relationship(type = "BoundedBy")
    @Getter
    private final Set<IfcRelSpaceBoundary> boundedBy = new HashSet<>();
}
