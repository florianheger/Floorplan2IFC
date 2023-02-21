package de.fheger.floorplan2ifc.gui.nodes;

import de.fheger.floorplan2ifc.gui.ImagePanel;
import de.fheger.floorplan2ifc.gui.panels.EntityPanel;
import javafx.scene.control.TreeItem;

public abstract class EntityNode<PanelType extends EntityPanel> extends TreeItem<ImagePanel> {
    protected PanelType entityPanel;

    public EntityNode(PanelType entityPanel, String iconName) {
        super(new ImagePanel(entityPanel.getName(), "/icons/" + iconName));
        this.entityPanel = entityPanel;
        entityPanel.onNameChanged(newName -> getValue().updateName(newName));

        setExpanded(true);
    }

    public PanelType getEntityPanel() {
        return entityPanel;
    }
}
