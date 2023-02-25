package de.fheger.floorplan2ifc.gui.entityinterfaces;

import de.fheger.floorplan2ifc.gui.panels.placement.length.WallPanel;

import java.util.List;

public interface IWall extends ILength {
    double getWallWidth();

    boolean isExternal();

    boolean isBearing();

    List<WallPanel> getInterferenceWalls();
}
