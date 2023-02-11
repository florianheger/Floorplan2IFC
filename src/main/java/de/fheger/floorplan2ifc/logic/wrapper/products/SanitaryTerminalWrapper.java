package de.fheger.floorplan2ifc.logic.wrapper.products;

import de.fheger.floorplan2ifc.gui.nodes.SanitaryTerminalNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.wrapper.ProductWrapper;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.distributionelement.distributionflowelement.flowterminal.IfcSanitaryTerminal;
import de.fheger.floorplan2ifc.models.enums.IfcSanitaryTerminalTypeEnum;

public class SanitaryTerminalWrapper extends ProductWrapper<SanitaryTerminalNode, IfcSanitaryTerminal> {
    public SanitaryTerminalWrapper(SanitaryTerminalNode elementNode) {
        super(elementNode, new IfcSanitaryTerminal());
    }

    @Override
    public void addRelationships() {

    }

    @Override
    public void addAttributes() throws ParseToIfcException {
        super.addAttributes();

        String typeString = getElementNode().getElementPanel().getSelectedType();
        try {
            IfcSanitaryTerminalTypeEnum typeEnum = IfcSanitaryTerminalTypeEnum.valueOf(typeString);
            getIfcElement().setPredefinedType(typeEnum);
        } catch (Exception e) {
            throw new ParseToIfcException("Selected not supported type for SanitaryTerminal " + getIfcElement().getName());
        }
    }
}
