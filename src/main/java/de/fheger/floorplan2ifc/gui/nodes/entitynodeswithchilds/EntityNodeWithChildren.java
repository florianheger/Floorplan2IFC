package de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds;

import de.fheger.floorplan2ifc.gui.nodes.EntityNode;
import de.fheger.floorplan2ifc.gui.panels.EntityPanel;
import javafx.scene.control.ContextMenu;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityNodeWithChildren<PanelType extends EntityPanel> extends EntityNode<PanelType> {

    protected ContextMenu menu = new ContextMenu();

    public EntityNodeWithChildren(PanelType entityPanel) {
        super(entityPanel);
        addItemsToMenu();
    }

    public abstract void addItemsToMenu();

    public ContextMenu getMenu() {
        return menu;
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
