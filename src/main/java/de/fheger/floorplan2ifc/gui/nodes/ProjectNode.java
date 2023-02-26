package de.fheger.floorplan2ifc.gui.nodes;

import de.fheger.floorplan2ifc.gui.panels.ProjectPanel;

import java.util.Collections;

public class ProjectNode extends de.fheger.floorplan2ifc.gui.nodes.EntityNode<ProjectPanel> {

    private static ProjectNode currentProject;

    public static ProjectNode getCurrentProject() {
        return currentProject;
    }

    public ProjectNode() {
        super(new ProjectPanel(), Collections.singletonList(SiteNode.class), "Project.png");
        currentProject = this;
    }
}
