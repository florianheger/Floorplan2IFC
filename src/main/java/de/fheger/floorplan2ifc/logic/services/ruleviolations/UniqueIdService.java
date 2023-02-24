package de.fheger.floorplan2ifc.logic.services.ruleviolations;

import de.fheger.floorplan2ifc.gui.nodes.EntityNode;
import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.EntityNodeWithChildren;
import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.logic.exceptions.IfcRuleViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UniqueIdService implements IRuleViolationService {
    @Override
    public void checkRuleViolation(ProjectNode projectNode) throws IfcRuleViolationException {
        List<String> globalIds = getGlobalIdsRecursive(projectNode);
        Set<String> globalIdsSet = new HashSet<>(globalIds);
        if (globalIds.size() != globalIdsSet.size()) {
            throw new IfcRuleViolationException("Not all GlobalIds are distinct.");
        }
    }

    private List<String> getGlobalIdsRecursive(EntityNode<?> entityNode) {
        List<String> globalIds = new ArrayList<>();
        globalIds.add(entityNode.getEntityPanel().getGlobalId());
        if (!(entityNode instanceof EntityNodeWithChildren<?> entityNodeWithChildren)) {
            return globalIds;
        }
        entityNodeWithChildren.getEntityNodeChildren().forEach(
                child -> globalIds.addAll(getGlobalIdsRecursive(child))
        );
        return globalIds;
    }
}
