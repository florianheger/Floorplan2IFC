package de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.distributionelement.distributionflowelement.flowterminal;

import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.distributionelement.distributionflowelement.IfcFlowTerminal;
import de.fheger.floorplan2ifc.models.enums.IfcSanitaryTerminalTypeEnum;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;

@SuppressWarnings("unused")
@Node
public class IfcSanitaryTerminal extends IfcFlowTerminal {
    @Setter
    private IfcSanitaryTerminalTypeEnum predefinedType;
}
