package de.fheger.floorplan2ifc.gui.nodes;

import de.fheger.floorplan2ifc.gui.panels.placement.length.DoorPanel;

public class DoorNode extends EntityNode<DoorPanel> {
    public DoorNode() {
        super(new DoorPanel(), "Door.png");
    }
}
