package de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds;

import de.fheger.floorplan2ifc.gui.nodes.EntityNode;
import de.fheger.floorplan2ifc.gui.panels.EntityPanel;
import javafx.scene.control.MenuItem;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityNodeWithChildren<PanelType extends EntityPanel> extends EntityNode<PanelType> {
    public EntityNodeWithChildren(PanelType entityPanel, List<Class<? extends EntityNode<?>>> possibleChildren, String iconName) {
        super(entityPanel, iconName);
        possibleChildren.forEach(this::addItemToMenu);
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

    public List<EntityNode<?>> getEntityNodeChildren() {
        List<EntityNode<?>> children = new ArrayList<>();
        for (int i = 0; i < getChildren().size(); i++) {
            if (!(getChildren().get(i) instanceof EntityNode<?> child)) {
                throw new RuntimeException("unsopported item in tree");
            }
            children.add(child);
        }
        return children;
    }
}
