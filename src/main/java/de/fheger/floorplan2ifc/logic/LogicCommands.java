package de.fheger.floorplan2ifc.logic;

import com.buildingsmart.tech.ifc.IfcKernel.IfcProject;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.logic.services.ParseToIfcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogicCommands {
    private ParseToIfcService parseToIfcService;

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
