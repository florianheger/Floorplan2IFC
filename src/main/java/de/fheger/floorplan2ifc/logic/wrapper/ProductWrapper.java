package de.fheger.floorplan2ifc.logic.wrapper;

import de.fheger.floorplan2ifc.gui.ElementNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.AddPlacementService;
import de.fheger.floorplan2ifc.logic.services.AddRootAttributesService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.IfcProduct;

public class ProductWrapper<NodeType extends ElementNode<?>, IfcType extends IfcProduct> extends Wrapper<NodeType, IfcType> {
    protected ProductWrapper(NodeType elementNode, IfcType ifcElement) {
        super(elementNode, ifcElement);
        addPlacement();
    }

    private void addPlacement() {
        AddPlacementService.addPlacement(getIfcElement(), getElementNode().getElementPanel());
    }

    @Override
    public void addAttributes() throws ParseToIfcException {
        super.addAttributes();
        AddRootAttributesService.addRootAttributes(getIfcElement(), getElementNode().getElementPanel());
    }

    @Override
    public void addRelationships() throws ParseToIfcException {

    }
}
