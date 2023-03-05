package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.interfaces.IEntity;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;

public interface IAddAttributesService<IfcType extends IfcObjectDefinition, IEntityType extends IEntity> {
    void addAttributes(IfcType ifcEntity, IEntityType iEntity) throws ParseToIfcException;
}
