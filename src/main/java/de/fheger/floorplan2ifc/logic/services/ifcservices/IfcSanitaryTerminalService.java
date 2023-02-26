package de.fheger.floorplan2ifc.logic.services.ifcservices;

import de.fheger.floorplan2ifc.gui.entityinterfaces.ISanitaryTerminal;
import de.fheger.floorplan2ifc.logic.services.FindIfcEntityService;
import de.fheger.floorplan2ifc.logic.services.ifcservices.attributes.IAddAttributesService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.distributionelement.distributionflowelement.flowterminal.IfcSanitaryTerminal;
import org.springframework.stereotype.Service;

@Service
public class IfcSanitaryTerminalService extends IfcService<IfcSanitaryTerminal, ISanitaryTerminal> {
    protected IfcSanitaryTerminalService(FindIfcEntityService findIfcEntityService, IAddAttributesService<IfcSanitaryTerminal, ISanitaryTerminal> addAttributes) {
        super(IfcSanitaryTerminal.class, ISanitaryTerminal.class, findIfcEntityService, addAttributes);
    }
}
