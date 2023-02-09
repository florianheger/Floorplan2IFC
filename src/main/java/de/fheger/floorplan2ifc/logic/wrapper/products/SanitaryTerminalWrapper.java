package de.fheger.floorplan2ifc.logic.wrapper.products;

import com.buildingsmart.tech.ifc.IfcPlumbingFireProtectionDomain.IfcSanitaryTerminal;
import com.buildingsmart.tech.ifc.IfcPlumbingFireProtectionDomain.IfcSanitaryTerminalTypeEnum;
import de.fheger.floorplan2ifc.gui.nodes.SanitaryTerminalNode;
import de.fheger.floorplan2ifc.logic.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.Wrapper;
import de.fheger.floorplan2ifc.logic.wrapper.ProductWrapper;

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
            throw new ParseToIfcException("Selected not supported type for SanitaryTerminal " + getIfcElement().getName().getValue());
        }
    }
}
