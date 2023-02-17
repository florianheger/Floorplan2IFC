package de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds;

import de.fheger.floorplan2ifc.gui.nodes.ElementNode;
import de.fheger.floorplan2ifc.gui.panels.ElementPanel;
import javafx.scene.control.ContextMenu;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementNodeWithChilds<PanelType extends ElementPanel> extends ElementNode<PanelType> {

    protected ContextMenu menu = new ContextMenu();

    public ElementNodeWithChilds(PanelType elementPanel) {
        super(elementPanel);
        addItemsToMenu();
    }

    public abstract void addItemsToMenu();

    public ContextMenu getMenu() {
        return menu;
    }

    public List<ElementNode<?>> getElementNodeChildren() {
        List<ElementNode<?>> children = new ArrayList<>();
        for (int i = 0; i < getChildren().size(); i++) {
            if (!(getChildren().get(i) instanceof ElementNode<?> child)) {
                throw new RuntimeException("unsopported item in tree");
            }
            children.add(child);
        }
        return children;
    }
}
