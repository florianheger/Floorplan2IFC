package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.interfaces.IWall;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWall;
import de.fheger.floorplan2ifc.models.entities.root.propertydefinition.propertysetdefinition.IfcPropertySet;
import de.fheger.floorplan2ifc.models.entities.root.propertydefinition.propertysetdefinition.quantityset.IfcElementQuantity;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldefines.IfcRelDefinesByProperties;
import de.fheger.floorplan2ifc.models.properties.propertyabstraction.property.simpleproperty.IfcPropertySingleValue;
import de.fheger.floorplan2ifc.models.properties.IfcBoolean;
import de.fheger.floorplan2ifc.models.quantities.physical.simple.IfcQuantityLength;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Service
public class AddWallAttributesService implements IAddAttributesService<IfcWall, IWall> {

    @Override
    public void addAttributes(IfcWall ifcWall, IWall iWall) {
        addQuantities(ifcWall, iWall);
        addPropertySets(ifcWall, iWall);
    }

    private void addPropertySets(IfcWall ifcWall, IWall iWall) {
        boolean isExternal = iWall.isExternal();
        boolean isBearing = iWall.isBearing();
        IfcBoolean isExternalB = new IfcBoolean(isExternal);
        IfcBoolean isBearingB = new IfcBoolean(isBearing);
        IfcPropertySingleValue isExternalPSV = new IfcPropertySingleValue(isExternalB);
        IfcPropertySingleValue isBearingPSV = new IfcPropertySingleValue(isBearingB);
        IfcPropertySet wallCommon = new IfcPropertySet(new HashSet<>(Arrays.asList(isExternalPSV, isBearingPSV)));
        IfcRelDefinesByProperties relWallProperties = new IfcRelDefinesByProperties(new HashSet<>(Collections.singleton(ifcWall)), wallCommon);
        ifcWall.getIsDefinedBy().add(relWallProperties);
    }

    private void addQuantities(IfcWall ifcWall, IWall iWall) {
        double length = iWall.getEntityLength();
        double width = iWall.getWallWidth();
        IfcQuantityLength qLength = new IfcQuantityLength("Length", length, "mm");
        IfcQuantityLength qWidth = new IfcQuantityLength("Width", width, "mm");
        IfcElementQuantity wallBasedQuantities = new IfcElementQuantity(new HashSet<>(Arrays.asList(qLength, qWidth)));
        IfcRelDefinesByProperties relWallQuantities = new IfcRelDefinesByProperties(new HashSet<>(Collections.singleton(ifcWall)), wallBasedQuantities);
        ifcWall.getIsDefinedBy().add(relWallQuantities);
        wallBasedQuantities.setDefinesOccurrence(relWallQuantities);
    }
}
