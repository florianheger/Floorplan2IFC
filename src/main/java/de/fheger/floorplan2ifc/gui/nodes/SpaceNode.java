package de.fheger.floorplan2ifc.gui.nodes;

import de.fheger.floorplan2ifc.gui.panels.placement.SpacePanel;

import java.util.Arrays;

public class SpaceNode extends de.fheger.floorplan2ifc.gui.nodes.EntityNode<SpacePanel> {
    public SpaceNode() {
        super(new SpacePanel(), Arrays.asList(SanitaryTerminalNode.class, ChimneyNode.class, StairNode.class), "Space.png");
    }
}
