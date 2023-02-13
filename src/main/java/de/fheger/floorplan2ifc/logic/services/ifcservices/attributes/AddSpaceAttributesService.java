package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.SpaceNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSpace;
import de.fheger.floorplan2ifc.models.entities.root.propertydefinition.propertysetdefinition.quantityset.IfcElementQuantity;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldefines.IfcRelDefinesByProperties;
import de.fheger.floorplan2ifc.models.quantities.physical.simple.IfcQuantityArea;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
public class AddSpaceAttributesService implements AddAttributes<IfcSpace, SpaceNode> {
    @Override
    public void addAttributes(IfcSpace ifcEntity, SpaceNode entityNode) throws ParseToIfcException {
        double floorArea = entityNode.getElementPanel().getFloorArea();
        IfcQuantityArea floorAreaQ = new IfcQuantityArea("NetFloorArea", floorArea, "mm^2");
        IfcElementQuantity wallBasedQuantities = new IfcElementQuantity(new HashSet<>(Collections.singleton(floorAreaQ)));
        IfcRelDefinesByProperties relWallQuantities = new IfcRelDefinesByProperties(new HashSet<>(Collections.singleton(ifcEntity)), wallBasedQuantities);
        ifcEntity.getIsDefinedBy().add(relWallQuantities);
        wallBasedQuantities.setDefinesOccurrence(relWallQuantities);
    }
}
