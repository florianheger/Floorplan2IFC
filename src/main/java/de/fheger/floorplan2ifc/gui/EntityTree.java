package de.fheger.floorplan2ifc.gui;

import de.fheger.floorplan2ifc.gui.nodes.EntityNode;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;

public class EntityTree extends TreeView<ImagePanel> {
    public EntityTree(EntityNode<?> root, Pane entityPane) {
        super(root);
        addTreeListener(entityPane);
    }

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
