package de.fheger.floorplan2ifc.logic.commands;


import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.logic.IfcProjectRepository;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.ParseToIfcService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogicCommands {
    private final ParseToIfcService parseToIfcService;
    private final IfcProjectRepository ifcProjectRepository;

    @Autowired
    public LogicCommands(ParseToIfcService parseToIfcService, IfcProjectRepository ifcProjectRepository) {
        this.parseToIfcService = parseToIfcService;
        this.ifcProjectRepository = ifcProjectRepository;
    }

    public IfcProject parseToIfcCommand(ProjectNode projectNode)
            throws ParseToIfcException {
        if (projectNode == null) {
            throw new ParseToIfcException("No current Project.");
        }
        IfcProject ifcProject = parseToIfcService.parseProject(projectNode);
        ifcProjectRepository.save(ifcProject);
        return ifcProject;
    }
}
