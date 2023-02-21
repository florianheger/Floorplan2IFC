package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.gui.nodes.SlabNode;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.IAddAttributesService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcSlab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IfcSlabService extends IfcService<IfcSlab, SlabNode> {
    @Autowired
    protected IfcSlabService(FindIfcEntityService findIfcEntityService, IAddAttributesService<IfcSlab, SlabNode> addAttributesService) {
        super(IfcSlab.class, SlabNode.class, findIfcEntityService, addAttributesService);
    }
}
