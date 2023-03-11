package de.fheger.floorplan2ifc.gui;

import de.fheger.floorplan2ifc.gui.nodes.EntityNode;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;

/**
 * TreeView for ImagePanels which represent entities.
 */

public class EntityTree extends TreeView<ImagePanel> {

    /**
     * @param root The root tree item. Normally an object of <i>ProjectNode</i>.
     * @param entityPane The main Pane of the Window which shows the EntityPanel.
     */
    public EntityTree(EntityNode<?> root, Pane entityPane) {
        super(root);
        addTreeListener(entityPane);
    }

    /**
     * Adds a Listener to the tree.
     * On right click, it shows the context menu of an entity.
     * On left click, it shows the EntityPanel of the clicked Tree item.
     * @param entityPane The main Pane of the Window which shows the EntityPanel.
     */
    private void addTreeListener(Pane entityPane) {
        TreeView<?> thisTree = this;
        setOnContextMenuRequested(event -> {
            if (getSelectionModel().getSelectedItem() instanceof EntityNode<?> selectedNode) {
                selectedNode.getMenu().show(thisTree, event.getScreenX(), event.getScreenY());
            }
        });
        setOnMouseClicked(event -> {
            if (getSelectionModel().getSelectedItem() instanceof EntityNode<?> selectedNode) {
                entityPane.getChildren().removeAll(entityPane.getChildren());
                entityPane.getChildren().add(selectedNode.getEntityPanel());
            }
        });
    }
}
