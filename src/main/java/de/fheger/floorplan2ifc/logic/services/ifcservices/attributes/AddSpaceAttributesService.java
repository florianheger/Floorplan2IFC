package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.interfaces.ISpace;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.spatialelement.spatialstructureelement.IfcSpace;
import de.fheger.floorplan2ifc.models.entities.root.propertydefinition.propertysetdefinition.IfcPropertySet;
import de.fheger.floorplan2ifc.models.entities.root.propertydefinition.propertysetdefinition.quantityset.IfcElementQuantity;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldefines.IfcRelDefinesByProperties;
import de.fheger.floorplan2ifc.models.properties.IfcLabel;
import de.fheger.floorplan2ifc.models.properties.propertyabstraction.property.simpleproperty.IfcPropertySingleValue;
import de.fheger.floorplan2ifc.models.quantities.physical.simple.IfcQuantityArea;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class AddSpaceAttributesService implements IAddAttributesService<IfcSpace, ISpace> {
    @Override
    public void addAttributes(IfcSpace ifcEntity, ISpace entityNode) throws ParseToIfcException {
        addFloorArea(ifcEntity, entityNode);
        addFloorAreaDin(ifcEntity, entityNode);
    }

    private void addFloorAreaDin(IfcSpace ifcEntity, ISpace iEntity) {
        if (iEntity.getFloorAreaDin() == null) {
            return;
        }

        String nuf = iEntity.getFloorAreaDin();
        IfcLabel nufLabel = new IfcLabel(nuf);
        IfcPropertySingleValue nufPSV = new IfcPropertySingleValue(nufLabel);
        IfcPropertySet nufSet = new IfcPropertySet(new HashSet<>(List.of(nufPSV)));
        IfcRelDefinesByProperties relNufProperty = new IfcRelDefinesByProperties(new HashSet<>(Collections.singleton(ifcEntity)), nufSet);
        ifcEntity.getIsDefinedBy().add(relNufProperty);
    }

    private void addFloorArea(IfcSpace ifcEntity, ISpace iEntity) {
        double floorArea = iEntity.getFloorArea();
        IfcQuantityArea floorAreaQ = new IfcQuantityArea("NetFloorArea", floorArea, "mm^2");
        IfcElementQuantity wallBasedQuantities = new IfcElementQuantity(new HashSet<>(Collections.singleton(floorAreaQ)));
        IfcRelDefinesByProperties relWallQuantities = new IfcRelDefinesByProperties(new HashSet<>(Collections.singleton(ifcEntity)), wallBasedQuantities);
        ifcEntity.getIsDefinedBy().add(relWallQuantities);
        wallBasedQuantities.setDefinesOccurrence(relWallQuantities);
    }
}
