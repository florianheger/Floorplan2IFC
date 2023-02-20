package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.gui.nodes.EntityNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;

public interface IAddAttributesService<IfcType extends IfcObjectDefinition, NodeType extends EntityNode<?>> {
    void addAttributes(IfcType ifcEntity, NodeType entityNode) throws ParseToIfcException;
}
