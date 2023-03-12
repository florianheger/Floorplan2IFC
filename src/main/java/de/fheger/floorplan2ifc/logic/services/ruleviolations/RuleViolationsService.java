package de.fheger.floorplan2ifc.logic.services.ruleviolations;

import de.fheger.floorplan2ifc.interfaces.IProject;
import de.fheger.floorplan2ifc.logic.exceptions.IfcRuleViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains all implementations of <i>IRuleViolationService</i> and checks it for a given <i>IProject</i>.
 */
@Service
public class RuleViolationsService implements IRuleViolationService {
    private final List<IRuleViolationService> ruleViolationServices = new ArrayList<>();

    @Autowired
    public RuleViolationsService(UniqueIdService uniqueIdService, DoorConnectsOneOrTwoSpaces doorConnectsOneOrTwoSpaces,
                                 SanitaryTerminalTypeSelectedService sanitaryTerminalTypeSelectedService) {
        ruleViolationServices.add(uniqueIdService);
        ruleViolationServices.add(doorConnectsOneOrTwoSpaces);
        ruleViolationServices.add(sanitaryTerminalTypeSelectedService);
    }

    /**
     * Check all rule violations for <i>project</i>.
     * @param project The project to be tested.
     * @throws IfcRuleViolationException If any service found a rule violation.
     */
    @Override
    public void checkRuleViolation(IProject project) throws IfcRuleViolationException {
        for (IRuleViolationService ruleViolationService : ruleViolationServices) {
            ruleViolationService.checkRuleViolation(project);
        }
    }
}
