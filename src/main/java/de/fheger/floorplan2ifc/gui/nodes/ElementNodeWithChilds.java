package de.fheger.floorplan2ifc.gui.nodes;

import de.fheger.floorplan2ifc.gui.ElementNode;
import de.fheger.floorplan2ifc.gui.ElementPanel;
import javafx.scene.control.ContextMenu;

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

    public ElementNode<?>[] getElementNodeChildren() {
        ElementNode<?>[] children = new ElementNode<?>[getChildren().size()];
        for (int i = 0; i < children.length; i++) {
            if (!(getChildren().get(i) instanceof ElementNode<?> child)) {
                throw new RuntimeException("unsopported item in tree");
            }
            children[i] = child;
        }
        return children;
    }
}
