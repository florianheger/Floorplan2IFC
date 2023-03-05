package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.interfaces.IPlacement;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.IfcProduct;
import de.fheger.floorplan2ifc.models.interfaces.IfcAxis2Placement;
import de.fheger.floorplan2ifc.models.placements.IfcLengthMeasure;
import de.fheger.floorplan2ifc.models.placements.IfcObjectPlacement;
import de.fheger.floorplan2ifc.models.placements.objectplacement.IfcLocalPlacement;
import de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem.placement.IfcAxis2Placement3D;
import de.fheger.floorplan2ifc.models.placements.representationitem.geometricrepresentationitem.point.IfcCartesianPoint;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class AddPlacementAttributesService implements IAddAttributesService<IfcProduct, IPlacement> {
    @Override
    public void addAttributes(IfcProduct ifcEntity, IPlacement iEntity) throws ParseToIfcException {
        double posX = iEntity.getPositionX();
        double posY = iEntity.getPositionY();
        double posZ = iEntity.getPositionZ();
        IfcLengthMeasure lengthMeasureX = new IfcLengthMeasure(posX);
        IfcLengthMeasure lengthMeasureY = new IfcLengthMeasure(posY);
        IfcLengthMeasure lengthMeasureZ = new IfcLengthMeasure(posZ);
        IfcCartesianPoint cartesianPoint = new IfcCartesianPoint(new HashSet<>(Arrays.asList(lengthMeasureX, lengthMeasureY, lengthMeasureZ)));
        IfcAxis2Placement axis2Placement = new IfcAxis2Placement3D(cartesianPoint);
        IfcObjectPlacement objectPlacement = new IfcLocalPlacement(axis2Placement);
        ifcEntity.setObjectPlacement(objectPlacement);
    }
}
