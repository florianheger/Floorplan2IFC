package de.fheger.floorplan2ifc.logic.services.ruleviolations;

import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import org.springframework.stereotype.Service;

@Service
public class UniqueIdService implements IRuleViolationService {
    @Override
    public void checkRuleViolation(IfcProject ifcProject) throws ParseToIfcException {

    }
}
