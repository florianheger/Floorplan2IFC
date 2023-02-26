package de.fheger.floorplan2ifc.gui.nodes;

import de.fheger.floorplan2ifc.gui.panels.placement.SitePanel;

import java.util.Collections;

public class SiteNode extends de.fheger.floorplan2ifc.gui.nodes.EntityNode<SitePanel> {
    public SiteNode() {
        super(new SitePanel(), Collections.singletonList(BuildingNode.class), "Site.png");
    }
}
