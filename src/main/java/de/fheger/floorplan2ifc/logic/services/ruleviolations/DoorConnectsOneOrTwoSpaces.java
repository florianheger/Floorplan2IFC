package de.fheger.floorplan2ifc.logic.services.ruleviolations;

import de.fheger.floorplan2ifc.gui.entityinterfaces.IDoor;
import de.fheger.floorplan2ifc.gui.entityinterfaces.IProject;
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
    public void checkRuleViolation(IProject project) throws IfcRuleViolationException {
        List<IDoor> allDoors = getAllIEntityPanelsOfType.getIfcEntityOfType(IDoor.class, project);

        for (IDoor door : allDoors) {
            if (!(door.getConnectedSpaces().size() == 1 || door.getConnectedSpaces().size() == 2)) {
                throw new IfcRuleViolationException("Door " + door.getName() + " connects to zero or more than two Spaces.");
            }
        }
    }
}
