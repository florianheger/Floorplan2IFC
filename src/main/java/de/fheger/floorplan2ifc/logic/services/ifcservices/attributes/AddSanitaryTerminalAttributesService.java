package de.fheger.floorplan2ifc.logic.services.ifcservices.attributes;

import de.fheger.floorplan2ifc.gui.nodes.SanitaryTerminalNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.object.product.element.distributionelement.distributionflowelement.flowterminal.IfcSanitaryTerminal;
import de.fheger.floorplan2ifc.models.enums.IfcSanitaryTerminalTypeEnum;
import org.springframework.stereotype.Service;

@Service
public class AddSanitaryTerminalAttributesService implements IAddAttributesService<IfcSanitaryTerminal, SanitaryTerminalNode> {
    @Override
    public void addAttributes(IfcSanitaryTerminal ifcEntity, SanitaryTerminalNode entityNode) throws ParseToIfcException {
        try {
            IfcSanitaryTerminalTypeEnum selectedType = IfcSanitaryTerminalTypeEnum.valueOf(entityNode.getEntityPanel().getSelectedType());
            ifcEntity.setPredefinedType(selectedType);
        } catch (NullPointerException ne) {
            throw new ParseToIfcException("Type of Sanitary Terminal " + ifcEntity.getName() + " not set.");
        }
    }
}
