package de.fheger.floorplan2ifc.gui.nodes;

import de.fheger.floorplan2ifc.gui.panels.ElementPanel;
import javafx.scene.control.TreeItem;

public abstract class ElementNode<PanelType extends ElementPanel> extends TreeItem<String> {
    protected PanelType elementPanel;

    public ElementNode(PanelType elementPanel) {
        super(elementPanel.getNameOrDefault());
        this.elementPanel = elementPanel;
        setExpanded(true);
    }

    public PanelType getElementPanel() {
        return elementPanel;
    }
}
