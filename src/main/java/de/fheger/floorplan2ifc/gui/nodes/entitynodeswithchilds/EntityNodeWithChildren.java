package de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds;

import de.fheger.floorplan2ifc.gui.ImagePanel;
import de.fheger.floorplan2ifc.gui.nodes.EntityNode;
import de.fheger.floorplan2ifc.gui.panels.EntityPanel;
import javafx.collections.ListChangeListener;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;

import java.util.List;

public abstract class EntityNodeWithChildren<PanelType extends EntityPanel> extends EntityNode<PanelType> {

    public EntityNodeWithChildren(PanelType entityPanel, List<Class<? extends EntityNode<?>>> possibleChildren, String iconName) {
        super(entityPanel, iconName);
        possibleChildren.forEach(this::addItemToMenu);

        addChildrenListener(entityPanel);
    }

    private void addChildrenListener(PanelType entityPanel) {
        getChildren().addListener((ListChangeListener<TreeItem<ImagePanel>>) c -> {
            c.getAddedSubList().forEach(child -> {
                if (child instanceof EntityNodeWithChildren<?> nc) {
                    entityPanel.getNodeChildren().add(nc);
                }
            });
            c.getRemoved().forEach(child -> {
                if (child instanceof EntityNodeWithChildren<?> nc) {
                    entityPanel.getNodeChildren().remove(nc);
                }
            });
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
}
