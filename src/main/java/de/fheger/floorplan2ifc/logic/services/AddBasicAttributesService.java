package de.fheger.floorplan2ifc.logic.services;

import com.buildingsmart.tech.ifc.IfcGeometricConstraintResource.IfcLocalPlacement;
import com.buildingsmart.tech.ifc.IfcGeometricConstraintResource.IfcObjectPlacement;
import com.buildingsmart.tech.ifc.IfcGeometryResource.IfcAxis2Placement;
import com.buildingsmart.tech.ifc.IfcGeometryResource.IfcAxis2Placement2D;
import com.buildingsmart.tech.ifc.IfcGeometryResource.IfcCartesianPoint;
import com.buildingsmart.tech.ifc.IfcKernel.IfcObjectDefinition;
import com.buildingsmart.tech.ifc.IfcKernel.IfcProduct;
import com.buildingsmart.tech.ifc.IfcKernel.IfcRoot;
import com.buildingsmart.tech.ifc.IfcMeasureResource.IfcLabel;
import com.buildingsmart.tech.ifc.IfcMeasureResource.IfcLengthMeasure;
import com.buildingsmart.tech.ifc.IfcMeasureResource.IfcText;
import de.fheger.floorplan2ifc.gui.ElementPanel;
import nl.tue.isbe.ifcspftools.GuidHandler;

import java.util.List;

public class AddBasicAttributesService {
    public static void addBasicAttributes(IfcObjectDefinition ifcElement, ElementPanel elementPanel) {
        String globalId = elementPanel.getGlobalId();
        IfcLabel name = new IfcLabel(elementPanel.getName());
        IfcText description = new IfcText(elementPanel.getDescription());

        ifcElement.setGlobalId(GuidHandler.getNewIfcGloballyUniqueId()); // TODO change
        ifcElement.setName(name);
        ifcElement.setDescription(description);
    }

    public static void addPlacement(IfcProduct ifcElement, ElementPanel elementPanel) {
        double posX = elementPanel.getPositionX();
        double posY = elementPanel.getPositionY();
        IfcLengthMeasure lengthMeasureX = new IfcLengthMeasure(posX);
        IfcLengthMeasure lengthMeasureY = new IfcLengthMeasure(posY);
        IfcCartesianPoint cartesianPoint = new IfcCartesianPoint(new IfcLengthMeasure[]{lengthMeasureX, lengthMeasureY});
        IfcAxis2Placement axis2Placement = new IfcAxis2Placement2D(cartesianPoint);
        IfcObjectPlacement objectPlacement = new IfcLocalPlacement(axis2Placement);
        ifcElement.setObjectPlacement(objectPlacement);
    }
}
