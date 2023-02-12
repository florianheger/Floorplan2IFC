package de.fheger.floorplan2ifc.logic.services.ifcservices.relationships;

import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.SpaceNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSpace;
import org.springframework.stereotype.Service;

@Service
public class AddSpaceRelationshipService implements AddRelationships<IfcSpace, SpaceNode> {
    @Override
    public void addRelationships(IfcSpace ifcEntity, SpaceNode entityNode) throws ParseToIfcException {

    }
}
