package de.fheger.floorplan2ifc.logic.wrapper;

import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;

// unabhängig von ProductWrapper, da keine Kinder
public class ProjectWrapper extends Wrapper<ProjectNode, IfcProject> {
    public ProjectWrapper(ProjectNode projectNode) {
        super(projectNode, new IfcProject());
    }

    @Override
    public void addRelationships() {

    }
}
