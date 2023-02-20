package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.ifcservices.*;
import de.fheger.floorplan2ifc.logic.services.ruleviolations.RuleViolationsService;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParseToIfcService {

    private final CreateIfcEntitiesService createIfcEntitiesService;
    private final RuleViolationsService ruleViolationsService;
    private final List<IfcService<?, ?>> ifcServices = new ArrayList<>();

    @Autowired
    public ParseToIfcService(CreateIfcEntitiesService createIfcEntitiesService,
                             IfcWallService ifcWallService,
                             IfcSpaceService ifcSpaceService,
                             IfcSanitaryTerminalService ifcSanitaryTerminalService,
                             IfcDoorService ifcDoorService,
                             IfcWindowService ifcWindowService, RuleViolationsService ruleViolationsService) {
        this.createIfcEntitiesService = createIfcEntitiesService;
        this.ruleViolationsService = ruleViolationsService;
        ifcServices.add(ifcWallService);
        ifcServices.add(ifcSpaceService);
        ifcServices.add(ifcSanitaryTerminalService);
        ifcServices.add(ifcDoorService);
        ifcServices.add(ifcWindowService);
    }

    public IfcProject parseProject(ProjectNode projectNode)
            throws ParseToIfcException {
        ruleViolationsService.checkRuleViolation(projectNode);

        IfcProject ifcProject = createIfcEntitiesService.createIfcEntitiesService(projectNode);

        for (IfcService<?, ?> ifcService : ifcServices) {
            ifcService.addAttributesAndRelationships(ifcProject, projectNode);
        }

        return ifcProject;
    }
}
