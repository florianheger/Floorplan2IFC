package de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds;

import de.fheger.floorplan2ifc.gui.nodes.ElementNodeWithChilds;
import de.fheger.floorplan2ifc.gui.nodes.SanitaryTerminalNode;
import de.fheger.floorplan2ifc.gui.panels.SpacePanel;
import javafx.scene.control.MenuItem;

public class SpaceNode extends ElementNodeWithChilds<SpacePanel> {
    public SpaceNode() {
        super(new SpacePanel());
    }

    @Override
    public void addItemsToMenu() {
        MenuItem item = new MenuItem("Add SanitaryTerminal");
        item.setOnAction(e -> getChildren().add(new SanitaryTerminalNode()));
        menu.getItems().add(item);
    }
}
