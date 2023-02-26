package de.fheger.floorplan2ifc.gui.nodes;

import de.fheger.floorplan2ifc.gui.panels.placement.BuildingPanel;

import java.util.Collections;

public class BuildingNode extends EntityNode<BuildingPanel> {


    public BuildingNode() {
        super(new BuildingPanel(), Collections.singletonList(BuildingStoreyNode.class), "Building.png");
    }
}
