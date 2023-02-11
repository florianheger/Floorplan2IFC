package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.gui.ElementPanel;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.IfcProduct;
import de.fheger.floorplan2ifc.models.helper.IfcObjectPlacement;
import nl.tue.isbe.ifcspftools.GuidHandler;

import java.util.List;

public class AddBasicAttributesService {
    public static void addBasicAttributes(IfcObjectDefinition ifcElement, ElementPanel elementPanel) {
        String globalId = elementPanel.getGlobalId();
        String name = elementPanel.getName();
        String description = elementPanel.getDescription();

        ifcElement.setGlobalId(globalId);
        ifcElement.setName(name);
        ifcElement.setDescription(description);
    }

    public static void addPlacement(IfcProduct ifcElement, ElementPanel elementPanel) {
//        double posX = elementPanel.getPositionX();
//        double posY = elementPanel.getPositionY();
//        IfcLengthMeasure lengthMeasureX = new IfcLengthMeasure(posX);
//        IfcLengthMeasure lengthMeasureY = new IfcLengthMeasure(posY);
//        IfcCartesianPoint cartesianPoint = new IfcCartesianPoint(new IfcLengthMeasure[]{lengthMeasureX, lengthMeasureY});
//        IfcAxis2Placement axis2Placement = new IfcAxis2Placement2D(cartesianPoint);
//        IfcObjectPlacement objectPlacement = new IfcLocalPlacement(axis2Placement);
//        ifcElement.setObjectPlacement(objectPlacement);
    }
}
