package de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds;

import de.fheger.floorplan2ifc.gui.nodes.DoorNode;
import de.fheger.floorplan2ifc.gui.nodes.WindowNode;
import de.fheger.floorplan2ifc.gui.panels.WallPanel;
import javafx.scene.control.MenuItem;

public class WallNode extends ElementNodeWithChilds<WallPanel> {


    public WallNode() {
        super(new WallPanel());
    }

    @Override
    public void addItemsToMenu() {
        MenuItem item = new MenuItem("Add Door");
        item.setOnAction(e -> getChildren().add(new DoorNode()));
        menu.getItems().add(item);
        MenuItem item2 = new MenuItem("Add Window");
        item2.setOnAction(e -> getChildren().add(new WindowNode()));
        menu.getItems().add(item2);
    }
}
