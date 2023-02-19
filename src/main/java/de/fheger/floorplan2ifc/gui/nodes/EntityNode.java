package de.fheger.floorplan2ifc.gui.nodes;

import de.fheger.floorplan2ifc.gui.panels.EntityPanel;
import javafx.scene.control.TreeItem;

public abstract class EntityNode<PanelType extends EntityPanel> extends TreeItem<String> {
    protected PanelType entityPanel;

    public EntityNode(PanelType entityPanel) {
        super(entityPanel.getNameOrDefault());
        this.entityPanel = entityPanel;

        entityPanel.onNameChanged(this::setValue);

        setExpanded(true);
    }

    public PanelType getEntityPanel() {
        return entityPanel;
    }
}
