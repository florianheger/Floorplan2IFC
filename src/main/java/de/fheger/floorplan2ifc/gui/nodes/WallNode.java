package de.fheger.floorplan2ifc.gui.nodes;

import de.fheger.floorplan2ifc.gui.panels.placement.length.WallPanel;

import java.util.Arrays;

public class WallNode extends de.fheger.floorplan2ifc.gui.nodes.EntityNode<WallPanel> {


    public WallNode() {
        super(new WallPanel(), Arrays.asList(DoorNode.class, WindowNode.class), "Wall.png");
    }
}
