package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.interfaces.IDimension;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.IfcElement;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.featureelement.featureelementsubtraction.IfcOpeningElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.relconnects.IfcRelFillsElement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddDimensionsToOpeningElement {
    public void addDimensionsToOpeningElement(IDimension dimension, IfcElement ifcDoorOrWindow)
            throws ParseToIfcException {
        IfcOpeningElement openingElement = getIfcOpeningElement(ifcDoorOrWindow);

        double length = dimension.getDimensionLength();
        double width = dimension.getDimensionWidth();
        double height = dimension.getDimensionHeight();
        openingElement.setLength(length);
        openingElement.setWidth(width);
        openingElement.setHeight(height);
    }

    private IfcOpeningElement getIfcOpeningElement(IfcElement ifcDoorOrWindow)
            throws ParseToIfcException {
        List<IfcRelFillsElement> relFills = ifcDoorOrWindow.getFillsVoids().stream().toList();
        if (relFills.size() != 1) {
            throw new ParseToIfcException(ifcDoorOrWindow.getName() + " has not exactly one Opening Element.");
        }
        return relFills.get(0).getRelatingOpeningElement();
    }
}
