package de.fheger.floorplan2ifc.gui.nodes.entitynodeswithchilds;

import de.fheger.floorplan2ifc.gui.panels.SitePanel;

import java.util.Collections;

public class SiteNode extends EntityNodeWithChildren<SitePanel> {
    public SiteNode() {
        super(new SitePanel(), Collections.singletonList(BuildingNode.class));
    }
}
