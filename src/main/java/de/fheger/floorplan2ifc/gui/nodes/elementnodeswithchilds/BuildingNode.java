package de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds;

import de.fheger.floorplan2ifc.gui.panels.BuildingPanel;
import javafx.scene.control.MenuItem;

public class BuildingNode extends ElementNodeWithChilds<BuildingPanel> {


    public BuildingNode() {
        super(new BuildingPanel());
    }

    @Override
    public void addItemsToMenu() {
        MenuItem item = new MenuItem("Add Storey");
        item.setOnAction(e -> getChildren().add(new BuildingStoreyNode()));
        menu.getItems().add(item);
    }
}
