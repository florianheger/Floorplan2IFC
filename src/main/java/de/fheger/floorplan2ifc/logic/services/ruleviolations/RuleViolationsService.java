package de.fheger.floorplan2ifc.logic.services.ruleviolations;

import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleViolationsService implements IRuleViolationService {
    private final UniqueIdService uniqueIdService;
    private final DoorConnectsOneOrTwoSpaces doorConnectsOneOrTwoSpaces;

    @Autowired
    public RuleViolationsService(UniqueIdService uniqueIdService, DoorConnectsOneOrTwoSpaces doorConnectsOneOrTwoSpaces) {
        this.uniqueIdService = uniqueIdService;
        this.doorConnectsOneOrTwoSpaces = doorConnectsOneOrTwoSpaces;
    }

    @Override
    public void checkRuleViolation(ProjectNode projectNode) throws ParseToIfcException {
        uniqueIdService.checkRuleViolation(projectNode);
        doorConnectsOneOrTwoSpaces.checkRuleViolation(projectNode);
    }
}
