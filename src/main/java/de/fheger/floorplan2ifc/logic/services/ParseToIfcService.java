package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.interfaces.IProject;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.services.ifcservices.*;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParseToIfcService {

    private final CreateIfcEntitiesService createIfcEntitiesService;
    private final List<IfcService<?, ?>> ifcServices = new ArrayList<>();

    @Autowired
    public ParseToIfcService(CreateIfcEntitiesService createIfcEntitiesService,
                             PlacementService placementService,
                             IfcWallService ifcWallService,
                             IfcSpaceService ifcSpaceService,
                             IfcSanitaryTerminalService ifcSanitaryTerminalService,
                             IfcDoorService ifcDoorService,
                             IfcWindowService ifcWindowService) {
        this.createIfcEntitiesService = createIfcEntitiesService;
        ifcServices.add(placementService);
        ifcServices.add(ifcWallService);
        ifcServices.add(ifcSpaceService);
        ifcServices.add(ifcSanitaryTerminalService);
        ifcServices.add(ifcDoorService);
        ifcServices.add(ifcWindowService);
    }

    public IfcProject parseProject(IProject project)
            throws ParseToIfcException {
        IfcProject ifcProject = createIfcEntitiesService.createIfcEntities(project);

        for (IfcService<?, ?> ifcService : ifcServices) {
            ifcService.addAttributesAndRelationships(ifcProject, project);
        }

        return ifcProject;
    }
}
