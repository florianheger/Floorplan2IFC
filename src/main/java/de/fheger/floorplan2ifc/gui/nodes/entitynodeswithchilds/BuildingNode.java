package de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds;

import de.fheger.floorplan2ifc.gui.panels.placement.BuildingPanel;

import java.util.Collections;

public class BuildingNode extends EntityNodeWithChildren<BuildingPanel> {


    public BuildingNode() {
        super(new BuildingPanel(), Collections.singletonList(BuildingStoreyNode.class));
    }
}
