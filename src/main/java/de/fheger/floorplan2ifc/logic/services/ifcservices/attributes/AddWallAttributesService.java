package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.WallNode;
import de.fheger.floorplan2ifc.gui.panels.WallPanel;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWall;
import de.fheger.floorplan2ifc.models.entities.root.propertydefinition.propertysetdefinition.quantityset.IfcElementQuantity;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldefines.IfcRelDefinesByProperties;
import de.fheger.floorplan2ifc.models.quantities.physical.simple.IfcQuantityLength;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Service
public class AddWallAttributesService implements AddAttributes<IfcWall, WallNode> {

    @Override
    public void addAttributes(IfcWall ifcWall, WallNode wallNode) {
        addQuantities(ifcWall, wallNode.getElementPanel());
        adPropertySets(ifcWall, wallNode.getElementPanel());
    }

    private void adPropertySets(IfcWall ifcWall, WallPanel wallPanel) {
//        boolean isExternal = wallPanel.isExternal();
//        boolean isBearing = wallPanel.isBearing();
//
//        IfcPropertySet wallCommon = new IfcPropertySet(hasProperties);
//        IfcRelDefinesByProperties relWallProperties = new IfcRelDefinesByProperties(new HashSet<>(Collections.singleton(ifcWall)), wallCommon);
//        ifcWall.getIsDefinedBy().add(relWallProperties);

        // wie funktioniert das weiter? In Property Set sind IfcPropertySingleValue, darin ist 1 Single Value wo drin Boolean gespeichert ist, aber wie?
    }

    private void addQuantities(IfcWall ifcWall, WallPanel wallPanel) {
        double length = wallPanel.getWallLength();
        double width = wallPanel.getWallWidth();
        IfcQuantityLength qLength = new IfcQuantityLength("Length", length, "mm");
        IfcQuantityLength qWidth = new IfcQuantityLength("Width", width, "mm");
        IfcElementQuantity wallBasedQuantities = new IfcElementQuantity(new HashSet<>(Arrays.asList(qLength, qWidth)));
        IfcRelDefinesByProperties relWallQuantities = new IfcRelDefinesByProperties(new HashSet<>(Collections.singleton(ifcWall)), wallBasedQuantities);
        ifcWall.getIsDefinedBy().add(relWallQuantities);
    }
}
