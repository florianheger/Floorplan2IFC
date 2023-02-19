package de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds;

import de.fheger.floorplan2ifc.gui.panels.placement.BuildingStoreyPanel;

import java.util.Arrays;

public class BuildingStoreyNode extends EntityNodeWithChildren<BuildingStoreyPanel> {

    public BuildingStoreyNode() {
        super(new BuildingStoreyPanel(), Arrays.asList(WallNode.class, SpaceNode.class));
    }
}
