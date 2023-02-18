package de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds;

import de.fheger.floorplan2ifc.gui.panels.BuildingStoreyPanel;
import javafx.scene.control.MenuItem;

public class BuildingStoreyNode extends EntityNodeWithChildren<BuildingStoreyPanel> {

    public BuildingStoreyNode() {
        super(new BuildingStoreyPanel());
    }

    @Override
    public void addItemsToMenu() {
        MenuItem item = new MenuItem("Add Wall");
        item.setOnAction(e -> getChildren().add(new WallNode()));
        menu.getItems().add(item);
        MenuItem item2 = new MenuItem("Add Space");
        item2.setOnAction(e -> getChildren().add(new SpaceNode()));
        menu.getItems().add(item2);
    }
}
