package de.fheger.floorplan2ifc.logic.services;

import com.buildingsmart.tech.ifc.IfcKernel.IfcProject;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.logic.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.Wrapper;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class ParseToIfcService {
    public IfcProject parseProject(ProjectNode projectNode)
            throws ParseToIfcException {
        Wrapper<?, ?>[] wrappers = CreateWrappersService.createWrappers(projectNode);
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
