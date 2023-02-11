package de.fheger.floorplan2ifc.logic.wrapper;

import de.fheger.floorplan2ifc.gui.ElementNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.AddBasicAttributesService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.IfcProduct;

public class ProductWrapper<NodeType extends ElementNode<?>, IfcType extends IfcProduct> extends Wrapper<NodeType, IfcType> {
    protected ProductWrapper(NodeType elementNode, IfcType ifcElement) {
        super(elementNode, ifcElement);
    }

    @Override
    public void addAttributes() throws ParseToIfcException {
        super.addAttributes();
        AddBasicAttributesService.addBasicAttributes(getIfcElement(), getElementNode().getElementPanel());
    }

    @Override
    public void addRelationships() throws ParseToIfcException {

    }
}
