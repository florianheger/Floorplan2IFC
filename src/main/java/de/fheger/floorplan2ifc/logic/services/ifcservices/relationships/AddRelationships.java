package de.fheger.floorplan2ifc.logic.services.ifcservices.relationships;

import de.fheger.floorplan2ifc.gui.ElementNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;

public interface AddRelationships<IfcType extends IfcObjectDefinition, NodeType extends ElementNode<?>> {
    void addRelationships(IfcType ifcEntity, NodeType entityNode) throws ParseToIfcException;
}
