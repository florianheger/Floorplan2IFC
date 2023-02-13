package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.gui.nodes.SanitaryTerminalNode;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.AddAttributes;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.distributionelement.distributionflowelement.flowterminal.IfcSanitaryTerminal;
import org.springframework.stereotype.Service;

@Service
public class IfcSanitaryTerminalService extends IfcService<IfcSanitaryTerminal, SanitaryTerminalNode> {
    protected IfcSanitaryTerminalService(FindIfcEntityService findIfcEntityService, AddAttributes<IfcSanitaryTerminal, SanitaryTerminalNode> addAttributes) {
        super(IfcSanitaryTerminal.class, SanitaryTerminalNode.class, findIfcEntityService, addAttributes);
    }
}
