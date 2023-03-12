package de.fheger.floorplan2ifc.logic.commands;


import de.fheger.floorplan2ifc.interfaces.IProject;
import de.fheger.floorplan2ifc.logic.exceptions.IfcRuleViolationException;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.exceptions.SaveToDatabaseException;
import de.fheger.floorplan2ifc.logic.services.ParseToIfcService;
import de.fheger.floorplan2ifc.logic.services.SaveToGraphDatabaseService;
import de.fheger.floorplan2ifc.logic.services.ruleviolations.RuleViolationsService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Interface for the gui package.
 */
@Component
public class LogicCommands {
    private final ParseToIfcService parseToIfcService;
    private final SaveToGraphDatabaseService saveToGraphDatabaseService;
    private final RuleViolationsService ruleViolationsService;

    @Autowired
    public LogicCommands(ParseToIfcService parseToIfcService, SaveToGraphDatabaseService saveToGraphDatabaseService, RuleViolationsService ruleViolationsService) {
        this.parseToIfcService = parseToIfcService;
        this.saveToGraphDatabaseService = saveToGraphDatabaseService;
        this.ruleViolationsService = ruleViolationsService;
    }

    private IfcProject parseToIfc(IProject project)
            throws ParseToIfcException {
        return parseToIfcService.parseProject(project);
    }

    public void checkIfProjectIsParsable(IProject project)
            throws ParseToIfcException {
        parseToIfc(project);
    }

    public void checkRuleViolations(IProject project)
            throws IfcRuleViolationException {
        ruleViolationsService.checkRuleViolation(project);
    }

    public void saveToGraphDatabase(IProject project)
            throws IfcRuleViolationException, ParseToIfcException, SaveToDatabaseException {
        checkRuleViolations(project);
        IfcProject ifcProject = parseToIfc(project);
        saveToGraphDatabaseService.save(ifcProject);
    }
}
