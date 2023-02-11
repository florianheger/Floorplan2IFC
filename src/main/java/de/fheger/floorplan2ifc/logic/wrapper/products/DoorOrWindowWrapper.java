package de.fheger.floorplan2ifc.logic.wrapper.products;


import de.fheger.floorplan2ifc.gui.ElementNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.wrapper.ProductWrapper;
import de.fheger.floorplan2ifc.models.entities.root.IfcObjectDefinition;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.IfcElement;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.featureelement.featureelementsubtraction.IfcOpeningElement;
import de.fheger.floorplan2ifc.models.entities.root.propertydefinition.propertysetdefinition.quantityset.IfcElementQuantity;
import de.fheger.floorplan2ifc.models.entities.root.relationship.relconnects.IfcRelFillsElement;
import de.fheger.floorplan2ifc.models.entities.root.relationship.reldefines.IfcRelDefinesByProperties;
import de.fheger.floorplan2ifc.models.quantities.IfcPhysicalQuantity;
import de.fheger.floorplan2ifc.models.quantities.physical.simple.IfcQuantityLength;
import nl.tue.isbe.ifcspftools.GuidHandler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public abstract class DoorOrWindowWrapper<NodeType extends ElementNode<?>, IfcType extends IfcElement> extends ProductWrapper<NodeType, IfcType> {
    protected DoorOrWindowWrapper(NodeType elementNode, IfcType ifcElement) {
        super(elementNode, ifcElement);
    }

    @Override
    public void addAttributes() throws ParseToIfcException {
        super.addAttributes();

        IfcOpeningElement relatedOpeningElement = getRelatedOpeningElement();
        int length = getElementLength();

        IfcQuantityLength quantityLength = new IfcQuantityLength("Width", length, "cm"); // TODO: change formula
        IfcElementQuantity elementQuantity = new IfcElementQuantity(new HashSet<>(Collections.singleton(quantityLength)));

        IfcRelDefinesByProperties tmp = new IfcRelDefinesByProperties(new HashSet<IfcObjectDefinition>(Collections.singleton(relatedOpeningElement)), elementQuantity);
        relatedOpeningElement.getIsDefinedBy().add(tmp);
    }

    private IfcOpeningElement getRelatedOpeningElement() throws ParseToIfcException {
        Iterator<IfcRelFillsElement> iterator = getIfcElement().getFillsVoids().iterator();
        if (!iterator.hasNext()) {
            throw new ParseToIfcException("Internal Error: No Opening Element created for door/window " + getIfcElement().getName());
        }
        return getIfcElement().getFillsVoids().iterator().next().getRelatingOpeningElement();
    }

    public abstract int getElementLength();
}
