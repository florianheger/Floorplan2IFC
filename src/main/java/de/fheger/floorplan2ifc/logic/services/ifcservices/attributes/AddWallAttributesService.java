package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.gui.panels.WallPanel;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWall;
import de.fheger.floorplan2ifc.models.entities.root.propertydefinition.propertysetdefinition.quantityset.IfcElementQuantity;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldefines.IfcRelDefinesByProperties;
import de.fheger.floorplan2ifc.models.quantities.physical.simple.IfcQuantityLength;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class AddWallAttributesService {
    public static void addAttributes(IfcWall ifcWall, WallPanel wallPanel) {
        addQuantities(ifcWall, wallPanel);
        adPropertySets(ifcWall, wallPanel);
    }

    private static void adPropertySets(IfcWall ifcWall, WallPanel wallPanel) {
//        boolean isExternal = wallPanel.isExternal();
//        boolean isBearing = wallPanel.isBearing();
//
//        IfcPropertySet wallCommon = new IfcPropertySet(hasProperties);
//        IfcRelDefinesByProperties relWallProperties = new IfcRelDefinesByProperties(new HashSet<>(Collections.singleton(ifcWall)), wallCommon);
//        ifcWall.getIsDefinedBy().add(relWallProperties);

        // wie funktioniert das weiter? In Property Set sind IfcPropertySingleValue, darin ist 1 Single Value wo drin Boolean gespeichert ist, aber wie?
    }

    private static void addQuantities(IfcWall ifcWall, WallPanel wallPanel) {
        double length = wallPanel.getWallLength();
        double width = wallPanel.getWallWidth();
        IfcQuantityLength qLength = new IfcQuantityLength("Length", length, "mm");
        IfcQuantityLength qWidth = new IfcQuantityLength("Width", width, "mm");
        IfcElementQuantity wallBasedQuantities = new IfcElementQuantity(new HashSet<>(Arrays.asList(qLength, qWidth)));
        IfcRelDefinesByProperties relWallQuantities = new IfcRelDefinesByProperties(new HashSet<>(Collections.singleton(ifcWall)), wallBasedQuantities);
        ifcWall.getIsDefinedBy().add(relWallQuantities);
    }
}
