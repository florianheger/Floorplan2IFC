package de.fheger.floorplan2ifc.gui.entityinterfaces;

import de.fheger.floorplan2ifc.gui.panels.placement.length.WallPanel;

import java.util.List;

public interface ISpace extends IPlacement {
    double getFloorArea();

    List<WallPanel> getBoundedWalls();

    String getFloorAreaDin();
}
