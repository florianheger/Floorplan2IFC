package de.fheger.floorplan2ifc.logic.services.ifcservices.relationships;

import de.fheger.floorplan2ifc.gui.nodes.EntityNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;

public interface IAddRelationshipsService<IfcType extends IfcObjectDefinition, NodeType extends EntityNode<?>> {
    void addRelationships(IfcType ifcEntity, NodeType entityNode) throws ParseToIfcException;
}
