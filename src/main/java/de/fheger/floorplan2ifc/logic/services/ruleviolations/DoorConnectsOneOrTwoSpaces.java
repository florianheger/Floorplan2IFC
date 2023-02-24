package de.fheger.floorplan2ifc.logic.services.ruleviolations;

import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.gui.panels.placement.length.DoorPanel;
import de.fheger.floorplan2ifc.logic.exceptions.IfcRuleViolationException;
import de.fheger.floorplan2ifc.logic.services.GetAllIEntityPanelsOfType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoorConnectsOneOrTwoSpaces implements IRuleViolationService {

    private final GetAllIEntityPanelsOfType getAllIEntityPanelsOfType;

    @Autowired
    public DoorConnectsOneOrTwoSpaces(GetAllIEntityPanelsOfType getAllIEntityPanelsOfType) {
        this.getAllIEntityPanelsOfType = getAllIEntityPanelsOfType;
    }


    @Override
    public void checkRuleViolation(ProjectNode projectNode) throws IfcRuleViolationException {
        List<DoorPanel> allDoors = getAllIEntityPanelsOfType.getIfcEntityOfType(DoorPanel.class, projectNode);

        for (DoorPanel door : allDoors) {
            if (!(door.getConnectedSpaces().size() == 1 || door.getConnectedSpaces().size() == 2)) {
                throw new IfcRuleViolationException("Door " + door.getName() + " connects to zero or more than two Spaces.sdsdf");
            }
        }
    }
}
