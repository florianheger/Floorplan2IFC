package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.IfcElement;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.featureelement.featureelementsubtraction.IfcOpeningElement;
import de.fheger.floorplan2ifc.models.entities.root.propertydefinition.propertysetdefinition.quantityset.IfcElementQuantity;
import de.fheger.floorplan2ifc.models.entities.root.relationship.relconnects.IfcRelFillsElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldefines.IfcRelDefinesByProperties;
import de.fheger.floorplan2ifc.models.quantities.physical.simple.IfcQuantityLength;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class AddLengthToOpeningElement {
    public void addLengthToOpeningElement(double width, IfcElement ifcDoorOrWindow)
            throws ParseToIfcException {
        List<IfcRelFillsElement> relFills = ifcDoorOrWindow.getFillsVoids().stream().toList();
        if (relFills.size() != 1) {
            throw new ParseToIfcException(ifcDoorOrWindow.getName() + " has not exactly one Opening Element.");
        }
        IfcOpeningElement openingElement = relFills.get(0).getRelatingOpeningElement();

        IfcQuantityLength widthQL = new IfcQuantityLength("Width", width, "mm");
        IfcElementQuantity elementQuantity = new IfcElementQuantity(new HashSet<>(Collections.singleton(widthQL)));
        IfcRelDefinesByProperties definesByProperties = new IfcRelDefinesByProperties(new HashSet<>(Collections.singleton(openingElement)), elementQuantity);
        openingElement.getIsDefinedBy().add(definesByProperties);
        elementQuantity.setDefinesOccurrence(definesByProperties);
    }
}
