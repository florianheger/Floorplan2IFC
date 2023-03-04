package de.fheger.floorplan2ifc.gui.nodes;

import de.fheger.floorplan2ifc.gui.panels.placement.dimension.WindowPanel;

public class WindowNode extends EntityNode<WindowPanel> {
    public WindowNode() {
        super(new WindowPanel(), "Window.png");
    }
}
