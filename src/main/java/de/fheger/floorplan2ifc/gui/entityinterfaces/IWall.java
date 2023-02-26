package de.fheger.floorplan2ifc.gui.entityinterfaces;

import java.util.List;

public interface IWall extends ILength {
    double getWallWidth();

    boolean isExternal();

    boolean isBearing();

    List<IWall> getInterferenceWalls();
}
