package de.fheger.floorplan2ifc.logic.services.ruleviolations;

import de.fheger.floorplan2ifc.interfaces.IProject;
import de.fheger.floorplan2ifc.logic.exceptions.IfcRuleViolationException;

public interface IRuleViolationService {
    void checkRuleViolation(IProject project)
            throws IfcRuleViolationException;
}
