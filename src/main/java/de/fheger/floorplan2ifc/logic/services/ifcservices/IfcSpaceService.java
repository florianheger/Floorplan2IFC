package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.SpaceNode;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.IAddAttributesService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.relationships.IAddRelationshipsService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IfcSpaceService extends IfcService<IfcSpace, SpaceNode> {
    @Autowired
    protected IfcSpaceService(FindIfcEntityService findIfcEntityService, IAddAttributesService<IfcSpace, SpaceNode> addAttributes, IAddRelationshipsService<IfcSpace, SpaceNode> addRelationships) {
        super(IfcSpace.class, SpaceNode.class, findIfcEntityService, addAttributes, addRelationships);
    }
}
