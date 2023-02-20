package de.fheger.floorplan2ifc.logic.commands;


import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.ParseToIfcService;
import de.fheger.floorplan2ifc.logic.services.SaveToGraphDatabaseService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogicCommands {
    private final ParseToIfcService parseToIfcService;
    private final SaveToGraphDatabaseService saveToGraphDatabaseService;

    @Autowired
    public LogicCommands(ParseToIfcService parseToIfcService, SaveToGraphDatabaseService saveToGraphDatabaseService) {
        this.parseToIfcService = parseToIfcService;
        this.saveToGraphDatabaseService = saveToGraphDatabaseService;
    }

    public IfcProject parseToIfc(de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.ProjectNode projectNode)
            throws ParseToIfcException {
        if (projectNode == null) {
            throw new ParseToIfcException("No current Project.");
        }
        IfcProject ifcProject = parseToIfcService.parseProject(projectNode);
        return ifcProject;
    }

    public void saveToGraphDatabase(IfcProject ifcProject) {
        saveToGraphDatabaseService.save(ifcProject);
    }
}
