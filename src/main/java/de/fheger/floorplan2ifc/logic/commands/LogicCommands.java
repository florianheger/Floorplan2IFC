package de.fheger.floorplan2ifc.logic.commands;


import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.logic.exceptions.IfcRuleViolationException;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.exceptions.SaveToDatabaseException;
import de.fheger.floorplan2ifc.logic.services.ParseToIfcService;
import de.fheger.floorplan2ifc.logic.services.SaveToGraphDatabaseService;
import de.fheger.floorplan2ifc.logic.services.ruleviolations.RuleViolationsService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    private IfcProject parseToIfc(ProjectNode projectNode)
            throws ParseToIfcException {
        return parseToIfcService.parseProject(projectNode);
    }

    public void checkIfProjectIsParsable(ProjectNode projectNode)
            throws ParseToIfcException {
        parseToIfc(projectNode);
    }

    public void checkRuleViolations(ProjectNode projectNode)
            throws IfcRuleViolationException {
        ruleViolationsService.checkRuleViolation(projectNode);
    }

    public void saveToGraphDatabase(ProjectNode projectNode)
            throws IfcRuleViolationException, ParseToIfcException, SaveToDatabaseException {
        checkRuleViolations(projectNode);
        IfcProject ifcProject = parseToIfc(projectNode);
        saveToGraphDatabaseService.save(ifcProject);
    }
}
