package de.fheger.floorplan2ifc.gui.nodes;

import de.fheger.floorplan2ifc.gui.panels.placement.BuildingStoreyPanel;

import java.util.Arrays;

public class BuildingStoreyNode extends EntityNode<BuildingStoreyPanel> {

    public BuildingStoreyNode() {
        super(new BuildingStoreyPanel(), Arrays.asList(WallNode.class, SpaceNode.class, SlabNode.class), "Floorplan.png");
    }
}
