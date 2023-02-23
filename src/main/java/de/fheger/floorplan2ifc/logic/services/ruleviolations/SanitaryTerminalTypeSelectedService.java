package de.fheger.floorplan2ifc.logic.services.ruleviolations;

import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.gui.panels.placement.SanitaryTerminalPanel;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.GetAllIEntityPanelsOfType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanitaryTerminalTypeSelectedService implements IRuleViolationService {

    private final GetAllIEntityPanelsOfType getAllIEntityPanelsOfType;

    @Autowired
    public SanitaryTerminalTypeSelectedService(GetAllIEntityPanelsOfType getAllIEntityPanelsOfType) {
        this.getAllIEntityPanelsOfType = getAllIEntityPanelsOfType;
    }

    @Override
    public void checkRuleViolation(ProjectNode projectNode) throws ParseToIfcException {
        List<SanitaryTerminalPanel> allSanitaryTerminals = getAllIEntityPanelsOfType.getIfcEntityOfType(SanitaryTerminalPanel.class, projectNode);

        for (SanitaryTerminalPanel sanitaryTerminal : allSanitaryTerminals) {
            if (sanitaryTerminal.getSelectedType() == null) {
                throw new ParseToIfcException("Type of Sanitary Terminal " + projectNode.getEntityPanel().getName() + " not set.");
            }
        }
    }
}
