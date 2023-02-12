package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.SpaceNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSpace;
import org.springframework.stereotype.Service;

@Service
public class AddRoomAttributesService implements AddAttributes<IfcSpace, SpaceNode>{
    @Override
    public void addAttributes(IfcSpace ifcEntity, SpaceNode entityNode) throws ParseToIfcException {
        double floorArea = entityNode.getElementPanel().getFloorArea();

    }
}
