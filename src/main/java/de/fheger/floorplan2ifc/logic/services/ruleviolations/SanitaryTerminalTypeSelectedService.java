package de.fheger.floorplan2ifc.logic.services.ruleviolations;

import de.fheger.floorplan2ifc.gui.entityinterfaces.IProject;
import de.fheger.floorplan2ifc.gui.entityinterfaces.ISanitaryTerminal;
import de.fheger.floorplan2ifc.logic.exceptions.IfcRuleViolationException;
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
    public void checkRuleViolation(IProject project) throws IfcRuleViolationException {
        List<ISanitaryTerminal> allSanitaryTerminals = getAllIEntityPanelsOfType.getIfcEntityOfType(ISanitaryTerminal.class, project);

        for (ISanitaryTerminal sanitaryTerminal : allSanitaryTerminals) {
            if (sanitaryTerminal.getSelectedType() == null) {
                throw new IfcRuleViolationException("Type of Sanitary Terminal " + project.getName() + " not set.");
            }
        }
    }
}
