package de.fheger.floorplan2ifc.logic.wrapper;

import com.buildingsmart.tech.ifc.IfcKernel.IfcProject;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.gui.panels.ProjectPanel;
import de.fheger.floorplan2ifc.logic.Wrapper;

public class ProjectWrapper extends Wrapper<ProjectNode, IfcProject> {
    public ProjectWrapper(ProjectNode projectNode) {
        super(projectNode, new IfcProject());
    }

    @Override
    public void addRelationships() {

    }
}
