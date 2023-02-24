package de.fheger.floorplan2ifc.gui.nodes;

import de.fheger.floorplan2ifc.gui.ImagePanel;
import de.fheger.floorplan2ifc.gui.panels.EntityPanel;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import lombok.Getter;

public abstract class EntityNode<PanelType extends EntityPanel> extends TreeItem<ImagePanel> {
    @Getter
    private final PanelType entityPanel;

    @Getter
    private final ContextMenu menu = new ContextMenu();

    public EntityNode(PanelType entityPanel, String iconName) {
        super(new ImagePanel(entityPanel.getName(), "/icons/" + iconName));
        this.entityPanel = entityPanel;
        entityPanel.onNameChanged(newName -> getValue().updateName(newName));

        addRemoveItem();

        setExpanded(true);
    }

    private void addRemoveItem() {
        MenuItem remove = new MenuItem("Remove object");
        remove.setOnAction(e -> remove());
        menu.getItems().add(remove);
    }

    private void remove() {
        entityPanel.remove();
        getParent().getChildren().remove(this);
    }
}
