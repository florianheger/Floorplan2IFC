package de.fheger.floorplan2ifc.gui.nodes;

import de.fheger.floorplan2ifc.gui.ImagePanel;
import de.fheger.floorplan2ifc.gui.panels.EntityPanel;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import lombok.Getter;

import java.util.List;

/**
 * Tree item for an Entity. Shows an ImagePanel.
 *
 * @param <PanelType> Corresponding implementation of <i>EntityPanel</i>.
 */

public abstract class EntityNode<PanelType extends EntityPanel> extends TreeItem<ImagePanel> {
    @Getter
    private final PanelType entityPanel;

    @Getter
    private final ContextMenu menu = new ContextMenu();

    /**
     * @param entityPanel Object of type PanelType. Should be created in subclass.
     * @param iconName    Path to the image for the ImagePanel.
     */
    public EntityNode(PanelType entityPanel, String iconName) {
        super(new ImagePanel(entityPanel.getName(), "/icons/" + iconName));
        this.entityPanel = entityPanel;
        entityPanel.onNameChanged(newName -> getValue().updateName(newName));

        addRemoveItem();

        setExpanded(true);
    }

    /**
     * @param entityPanel      Object of type PanelType. Should be created in subclass.
     * @param possibleChildren List of all classes of possible children for this entity.
     * @param iconName         Path to the image for the ImagePanel.
     */
    public EntityNode(PanelType entityPanel, List<Class<? extends EntityNode<?>>> possibleChildren, String iconName) {
        super(new ImagePanel(entityPanel.getName(), "/icons/" + iconName));

        this.entityPanel = entityPanel;
        entityPanel.onNameChanged(newName -> getValue().updateName(newName));

        addRemoveItem();
        possibleChildren.forEach(this::addItemToMenu);
        addChildrenListener();


        setExpanded(true);
    }

    /**
     * Listener for added and removed children. The children's list in the corresponding EntityPanel needs to be updated as it is implementing the IEntity interface.
     */
    private void addChildrenListener() {
        getChildren().addListener((ListChangeListener<TreeItem<ImagePanel>>) c -> {
            while (c.next()) {
                c.getAddedSubList().forEach(child -> entityPanel.getNodeChildren().add((EntityNode<?>) child));
                c.getRemoved().forEach(child -> entityPanel.getNodeChildren().remove((EntityNode<?>) child));
            }
        });
    }

    /**
     * Adds an option to add a possible child to this entity.
     * @param nodeClazz Class object of the possible child.
     */
    private void addItemToMenu(Class<? extends EntityNode<?>> nodeClazz) {
        String itemName = "Add " + nodeClazz.getSimpleName();
        itemName = itemName.replace("Node", "");
        MenuItem item = new MenuItem(itemName);
        item.setOnAction(e -> {
            try {
                getChildren().add(nodeClazz.getDeclaredConstructor().newInstance());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        getMenu().getItems().add(item);
    }

    /**
     * Add an option to remove the entity to the context menu.
     */
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
