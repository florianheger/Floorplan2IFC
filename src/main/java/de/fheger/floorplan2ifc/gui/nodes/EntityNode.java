package de.fheger.floorplan2ifc.gui.nodes;

import de.fheger.floorplan2ifc.gui.ImagePanel;
import de.fheger.floorplan2ifc.gui.panels.EntityPanel;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import lombok.Getter;

import java.util.List;

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

    public EntityNode(PanelType entityPanel, List<Class<? extends EntityNode<?>>> possibleChildren, String iconName) {
        super(new ImagePanel(entityPanel.getName(), "/icons/" + iconName));

        this.entityPanel = entityPanel;
        entityPanel.onNameChanged(newName -> getValue().updateName(newName));

        addRemoveItem();
        possibleChildren.forEach(this::addItemToMenu);
        addChildrenListener();


        setExpanded(true);
    }

    private void addChildrenListener() {
        getChildren().addListener((ListChangeListener<TreeItem<ImagePanel>>) c -> {
            while (c.next()) {
                c.getAddedSubList().forEach(child -> entityPanel.getNodeChildren().add((EntityNode<?>) child));
                c.getRemoved().forEach(child -> entityPanel.getNodeChildren().remove((EntityNode<?>) child));
            }
        });
    }

    protected void addItemToMenu(Class<? extends EntityNode<?>> nodeClazz) {
        MenuItem item = new MenuItem("Add " + nodeClazz.getSimpleName());
        item.setOnAction(e -> {
            try {
                getChildren().add(nodeClazz.getDeclaredConstructor().newInstance());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        getMenu().getItems().add(item);
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
