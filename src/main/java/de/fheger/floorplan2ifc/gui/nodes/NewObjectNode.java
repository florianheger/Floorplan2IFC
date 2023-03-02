package de.fheger.floorplan2ifc.gui.nodes;

import de.fheger.floorplan2ifc.gui.panels.placement.NewObjectPanel;

import java.util.Arrays;

public class NewObjectNode extends EntityNode<NewObjectPanel> {
    public NewObjectNode() {
        super(new NewObjectPanel(), Arrays.asList(DoorNode.class, WindowNode.class), "new-object.png");
    }
}
