package de.fheger.floorplan2ifc.logic.services.ruleviolations;

import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.logic.exceptions.IfcRuleViolationException;

public interface IRuleViolationService {
    void checkRuleViolation(ProjectNode projectNode)
            throws IfcRuleViolationException;
}
