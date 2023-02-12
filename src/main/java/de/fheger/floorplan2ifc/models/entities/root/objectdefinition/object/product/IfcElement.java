package de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.IfcProduct;
import de.fheger.floorplan2ifc.models.entities.root.relationship.relconnects.IfcRelFillsElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.relconnects.IfcRelInterferesElements;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelSpaceBoundary;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldecomposes.IfcRelVoidsElement;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

public abstract class IfcElement extends IfcProduct {
    @Relationship(type = "HasOpenings")
    @Getter
    private final Set<IfcRelVoidsElement> hasOpenings = new HashSet<>();

    @Relationship(type = "FillsVoids")
    @Getter
    private final Set<IfcRelFillsElement> fillsVoids = new HashSet<>();

    @Relationship(type = "IsInterferedByElements")
    @Getter
    private final Set<IfcRelInterferesElements> isInterferedByElements = new HashSet<>();

    @Relationship(type = "InterferesElements")
    @Getter
    private final Set<IfcRelInterferesElements> interferesElements = new HashSet<>();

    @Relationship(type = "ProvidesBoundaries")
    @Getter
    private final Set<IfcRelSpaceBoundary> providesBoundaries = new HashSet<>();
}
