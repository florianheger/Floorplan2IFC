package de.fheger.floorplan2ifc.logic.services.ruleviolations;

import de.fheger.floorplan2ifc.interfaces.IEntity;
import de.fheger.floorplan2ifc.interfaces.IProject;
import de.fheger.floorplan2ifc.logic.exceptions.IfcRuleViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UniqueIdService implements IRuleViolationService {
    @Override
    public void checkRuleViolation(IProject project) throws IfcRuleViolationException {
        List<String> globalIds = getGlobalIdsRecursive(project);
        Set<String> globalIdsSet = new HashSet<>(globalIds);
        if (globalIds.size() != globalIdsSet.size()) {
            throw new IfcRuleViolationException("Not all GlobalIds are distinct.");
        }
    }

    private List<String> getGlobalIdsRecursive(IEntity entity) {
        List<String> globalIds = new ArrayList<>();
        globalIds.add(entity.getGlobalId());
        if (!entity.hasChildren()) {
            return globalIds;
        }
        entity.getIEntityChildren().forEach(
                child -> globalIds.addAll(getGlobalIdsRecursive(child))
        );
        return globalIds;
    }
}
