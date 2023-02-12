package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.SpaceNode;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.AddAttributes;
import de.fheger.floorplan2ifc.logic.services.ifcservices.relationships.AddRelationships;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IfcSpaceService extends IfcService<IfcSpace, SpaceNode> {
    @Autowired
    protected IfcSpaceService(FindIfcEntityService findIfcEntityService, AddAttributes<IfcSpace, SpaceNode> addAttributes, AddRelationships<IfcSpace, SpaceNode> addRelationships) {
        super(IfcSpace.class, SpaceNode.class, findIfcEntityService, addAttributes, addRelationships);
    }
}
