package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.gui.ElementNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;

public interface AddAttributes<IfcType extends IfcObjectDefinition, NodeType extends ElementNode<?>> {
    void addAttributes(IfcType ifcEntity, NodeType entityNode) throws ParseToIfcException;
}
