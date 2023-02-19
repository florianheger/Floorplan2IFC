package de.fheger.floorplan2ifc.logic.services.ruleviolations;

import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleViolationsService implements IRuleViolationService {
    private final UniqueIdService uniqueIdService;

    @Autowired
    public RuleViolationsService(UniqueIdService uniqueIdService) {
        this.uniqueIdService = uniqueIdService;
    }

    @Override
    public void checkRuleViolation(IfcProject ifcProject) throws ParseToIfcException {
        uniqueIdService.checkRuleViolation(ifcProject);
    }
}
