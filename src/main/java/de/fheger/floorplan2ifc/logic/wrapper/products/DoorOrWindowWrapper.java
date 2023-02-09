package de.fheger.floorplan2ifc.logic.wrapper.products;

import com.buildingsmart.tech.ifc.IfcKernel.IfcObjectDefinition;
import com.buildingsmart.tech.ifc.IfcKernel.IfcRelDefinesByProperties;
import com.buildingsmart.tech.ifc.IfcMeasureResource.IfcLabel;
import com.buildingsmart.tech.ifc.IfcMeasureResource.IfcLengthMeasure;
import com.buildingsmart.tech.ifc.IfcProductExtension.IfcElement;
import com.buildingsmart.tech.ifc.IfcProductExtension.IfcElementQuantity;
import com.buildingsmart.tech.ifc.IfcProductExtension.IfcOpeningElement;
import com.buildingsmart.tech.ifc.IfcProductExtension.IfcRelFillsElement;
import com.buildingsmart.tech.ifc.IfcQuantityResource.IfcPhysicalQuantity;
import com.buildingsmart.tech.ifc.IfcQuantityResource.IfcQuantityLength;
import de.fheger.floorplan2ifc.gui.ElementNode;
import de.fheger.floorplan2ifc.logic.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.Wrapper;
import de.fheger.floorplan2ifc.logic.wrapper.ProductWrapper;
import nl.tue.isbe.ifcspftools.GuidHandler;

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

        IfcQuantityLength quantityLength = new IfcQuantityLength();
        quantityLength.setName(new IfcLabel("Width"));
        quantityLength.setLengthValue(new IfcLengthMeasure((double)length));
        quantityLength.setFormula(new IfcLabel("cm"));
        IfcElementQuantity elementQuantity = new IfcElementQuantity(GuidHandler.getNewIfcGloballyUniqueId(), new IfcPhysicalQuantity[]{quantityLength});

        IfcRelDefinesByProperties tmp = new IfcRelDefinesByProperties("", new IfcObjectDefinition[]{relatedOpeningElement}, elementQuantity);
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
