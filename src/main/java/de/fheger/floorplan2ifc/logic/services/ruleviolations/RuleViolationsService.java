package de.fheger.floorplan2ifc.logic.services.ruleviolations;

import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.logic.exceptions.IfcRuleViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void checkRuleViolation(ProjectNode projectNode) throws IfcRuleViolationException {
        for (IRuleViolationService ruleViolationService : ruleViolationServices) {
            ruleViolationService.checkRuleViolation(projectNode);
        }
    }
}
