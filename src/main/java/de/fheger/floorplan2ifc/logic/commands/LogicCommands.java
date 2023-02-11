package de.fheger.floorplan2ifc.logic.commands;


import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.ParseToIfcService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogicCommands {
    private final ParseToIfcService parseToIfcService;

    @Autowired
    public LogicCommands(ParseToIfcService parseToIfcService) {
        this.parseToIfcService = parseToIfcService;
    }

    public IfcProject parseToIfcCommand(ProjectNode projectNode)
            throws ParseToIfcException {
        if (projectNode == null) {
            throw new ParseToIfcException("No current Project.");
        }
        return parseToIfcService.parseProject(projectNode);
    }
}
