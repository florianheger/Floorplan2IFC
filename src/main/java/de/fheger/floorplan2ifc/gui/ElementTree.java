package de.fheger.floorplan2ifc.gui;

import de.fheger.floorplan2ifc.gui.nodes.ElementNode;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.ElementNodeWithChilds;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;

public class ElementTree extends TreeView<String> {
    public ElementTree(ElementNode<?> root, Pane elementPane) {
        super(root);
        TreeView<String> tree = this;
        setOnContextMenuRequested(event -> {
            if (getSelectionModel().getSelectedItem() instanceof ElementNodeWithChilds<?> selectedNode) {
                selectedNode.getMenu().show(tree, event.getScreenX(), event.getScreenY());
            }
        });
        setOnMouseClicked(event -> {
            if (getSelectionModel().getSelectedItem() instanceof ElementNode<?> selectedNode) {
                elementPane.getChildren().removeAll(elementPane.getChildren());
                elementPane.getChildren().add(selectedNode.getElementPanel());
            }
        });
    }
}
