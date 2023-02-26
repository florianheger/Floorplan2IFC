package de.fheger.floorplan2ifc.logic.services.ifcservices.relationships;

import de.fheger.floorplan2ifc.interfaces.IEntity;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;

public interface IAddRelationshipsService<IfcType extends IfcObjectDefinition, IEntityType extends IEntity> {
    void addRelationships(IfcType ifcEntity, IEntityType entityNode) throws ParseToIfcException;
}
