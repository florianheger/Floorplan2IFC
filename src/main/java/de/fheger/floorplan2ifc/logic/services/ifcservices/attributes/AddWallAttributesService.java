package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.interfaces.IWall;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.builtelement.IfcWall;
import de.fheger.floorplan2ifc.models.placements.objectplacement.IfcLocalPlacement;
import org.springframework.stereotype.Service;

@Service
public class AddWallAttributesService implements IAddAttributesService<IfcWall, IWall> {

    @Override
    public void addAttributes(IfcWall ifcWall, IWall iEntity)
            throws ParseToIfcException {
        addQuantities(ifcWall, iEntity);
        addProperties(ifcWall, iEntity);
        addRotation(ifcWall, iEntity);
    }

    private void addRotation(IfcWall ifcWall, IWall iWall) throws ParseToIfcException {
        if (!(ifcWall.getObjectPlacement() instanceof IfcLocalPlacement ifcLocalPlacement)) {
            throw new ParseToIfcException("Error adding rotation to wall " + ifcWall.getName());
        }
        double rotation = iWall.getRotation();
        ifcLocalPlacement.setRotation(rotation);
    }

    private void addProperties(IfcWall ifcWall, IWall iWall) {
        boolean isExternal = iWall.isExternal();
        boolean isBearing = iWall.isBearing();
        ifcWall.setExternal(isExternal);
        ifcWall.setBearing(isBearing);
    }

    private void addQuantities(IfcWall ifcWall, IWall iWall) {
        double length = iWall.getDimensionLength();
        double width = iWall.getDimensionWidth();
        double height = iWall.getDimensionHeight();
        ifcWall.setLength(length);
        ifcWall.setWidth(width);
        ifcWall.setHeight(height);
    }
}
