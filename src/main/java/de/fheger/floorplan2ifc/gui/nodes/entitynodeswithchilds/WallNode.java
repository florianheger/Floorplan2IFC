package de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds;

import de.fheger.floorplan2ifc.gui.nodes.DoorNode;
import de.fheger.floorplan2ifc.gui.nodes.WindowNode;
import de.fheger.floorplan2ifc.gui.panels.WallPanel;

import java.util.Arrays;

public class WallNode extends EntityNodeWithChildren<WallPanel> {


    public WallNode() {
        super(new WallPanel(), Arrays.asList(DoorNode.class, WindowNode.class));
    }
}
