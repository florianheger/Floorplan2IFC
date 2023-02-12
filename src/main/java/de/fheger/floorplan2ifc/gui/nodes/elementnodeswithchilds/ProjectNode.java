package de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds;

import de.fheger.floorplan2ifc.gui.nodes.ElementNodeWithChilds;
import de.fheger.floorplan2ifc.gui.panels.ProjectPanel;
import javafx.scene.control.MenuItem;

public class ProjectNode extends ElementNodeWithChilds<ProjectPanel> {

    private static ProjectNode currentProject;

    public static ProjectNode getCurrentProject() {
        return currentProject;
    }

    public ProjectNode() {
        super(new ProjectPanel());
        currentProject = this;
    }

    @Override
    public void addItemsToMenu() {
        MenuItem item = new MenuItem("Add Site");
        item.setOnAction(e -> getChildren().add(new SiteNode()));
        menu.getItems().add(item);
    }
}