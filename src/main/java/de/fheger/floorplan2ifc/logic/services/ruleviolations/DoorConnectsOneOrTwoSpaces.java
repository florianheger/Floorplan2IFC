package de.fheger.floorplan2ifc.logic.services.ruleviolations;

import de.fheger.floorplan2ifc.gui.nodes.DoorNode;
import de.fheger.floorplan2ifc.gui.nodes.EntityNode;
import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.EntityNodeWithChildren;
import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.gui.panels.placement.length.DoorPanel;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoorConnectsOneOrTwoSpaces implements IRuleViolationService {
    @Override
    public void checkRuleViolation(ProjectNode projectNode) throws ParseToIfcException {
        List<DoorPanel> allDoors = getAllDoorsRecursive(projectNode);

        for (DoorPanel door : allDoors) {
            if (!(door.getConnectedSpaces().size() == 1 || door.getConnectedSpaces().size() == 2)) {
                throw new ParseToIfcException("Door " + door.getName() + " connects to zero or more than two Spaces.");
            }
        }
    }

    private List<DoorPanel> getAllDoorsRecursive(EntityNode<?> entityNode) {
        List<DoorPanel> allDoors = new ArrayList<>();
        if (entityNode instanceof DoorNode doorNode) {
            allDoors.add(doorNode.getEntityPanel());
        }
        if (entityNode instanceof EntityNodeWithChildren<?> entityNodeWithChildren) {
            entityNodeWithChildren.getEntityNodeChildren().forEach(
                    child -> allDoors.addAll(getAllDoorsRecursive(child))
            );
        }
        return allDoors;
    }
}
