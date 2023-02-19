package de.fheger.floorplan2ifc.logic.services.ruleviolations;

import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;

public interface IRuleViolationService {
    void checkRuleViolation(IfcProject ifcProject)
            throws ParseToIfcException;
}
