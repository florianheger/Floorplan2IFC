package de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds;

import de.fheger.floorplan2ifc.gui.panels.SitePanel;
import javafx.scene.control.MenuItem;

public class SiteNode extends ElementNodeWithChilds<SitePanel> {
    public SiteNode() {
        super(new SitePanel());
    }

    @Override
    public void addItemsToMenu() {
        MenuItem item = new MenuItem("Add Building");
        item.setOnAction(e -> getChildren().add(new BuildingNode()));
        menu.getItems().add(item);
    }
}
