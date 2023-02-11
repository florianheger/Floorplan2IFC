package de.fheger.floorplan2ifc.logic.services;

import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.wrapper.Wrapper;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParseToIfcService {

    private CreateWrappersService createWrappersService;

    @Autowired
    public ParseToIfcService(CreateWrappersService createWrappersService) {
        this.createWrappersService = createWrappersService;
    }


    public IfcProject parseProject(ProjectNode projectNode)
            throws ParseToIfcException {
        Wrapper<?, ?>[] wrappers = createWrappersService.createWrappers(projectNode);

        for (Wrapper<?, ?> wrapper : wrappers) {
            wrapper.addRelAggregateToChildren();
        }
        for (Wrapper<?, ?> wrapper : wrappers) {
            wrapper.addAttributes();
        }
        for (Wrapper<?, ?> wrapper : wrappers) {
            wrapper.addRelationships();
        }

        return Wrapper.getMatchingWrapper(projectNode).getIfcProjectAndClean();
    }
}
