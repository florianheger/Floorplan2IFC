package de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds;

import de.fheger.floorplan2ifc.gui.nodes.ChimneyNode;
import de.fheger.floorplan2ifc.gui.nodes.SanitaryTerminalNode;
import de.fheger.floorplan2ifc.gui.panels.placement.SpacePanel;

import java.util.Arrays;

public class SpaceNode extends EntityNodeWithChildren<SpacePanel> {
    public SpaceNode() {
        super(new SpacePanel(), Arrays.asList(SanitaryTerminalNode.class, ChimneyNode.class));
    }
}
