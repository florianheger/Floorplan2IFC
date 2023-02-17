package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.gui.panels.ElementPanel;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.IfcProduct;
import de.fheger.floorplan2ifc.models.placements.IfcLengthMeasure;
import de.fheger.floorplan2ifc.models.placements.IfcObjectPlacement;
import de.fheger.floorplan2ifc.models.placements.objectplacement.IfcLocalPlacement;
import de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem.placement.IfcAxis2Placement;
import de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem.placement.IfcAxis2Placement2D;
import de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem.point.IfcCartesianPoint;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class AddPlacementService {
    public void addPlacement(IfcProduct ifcEntity, ElementPanel elementPanel) {
        double posX = elementPanel.getPositionX();
        double posY = elementPanel.getPositionY();
        IfcLengthMeasure lengthMeasureX = new IfcLengthMeasure(posX);
        IfcLengthMeasure lengthMeasureY = new IfcLengthMeasure(posY);
        IfcCartesianPoint cartesianPoint = new IfcCartesianPoint(new HashSet<>(Arrays.asList(lengthMeasureX, lengthMeasureY)));
        IfcAxis2Placement axis2Placement = new IfcAxis2Placement2D(cartesianPoint);
        IfcObjectPlacement objectPlacement = new IfcLocalPlacement(axis2Placement);
        ifcEntity.setObjectPlacement(objectPlacement);
    }
}
