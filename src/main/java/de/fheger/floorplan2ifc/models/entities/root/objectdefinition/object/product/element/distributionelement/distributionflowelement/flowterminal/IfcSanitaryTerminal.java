package de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.distributionelement.distributionflowelement.flowterminal;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.distributionelement.distributionflowelement.IfcFlowTerminal;
import de.fheger.floorplan2ifc.models.enums.IfcSanitaryTerminalTypeEnum;
import lombok.Setter;

@SuppressWarnings("unused")
public class IfcSanitaryTerminal extends IfcFlowTerminal {
    @Setter
    private IfcSanitaryTerminalTypeEnum predefinedType;
}
