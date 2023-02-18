package de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds;

import de.fheger.floorplan2ifc.gui.panels.ProjectPanel;

import java.util.Collections;

public class ProjectNode extends EntityNodeWithChildren<ProjectPanel> {

    private static ProjectNode currentProject;

    public static ProjectNode getCurrentProject() {
        return currentProject;
    }

    public ProjectNode() {
        super(new ProjectPanel(), Collections.singletonList(SiteNode.class));
        currentProject = this;
    }
}
