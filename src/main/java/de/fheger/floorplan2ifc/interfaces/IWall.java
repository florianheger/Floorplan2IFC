package de.fheger.floorplan2ifc.interfaces;

import java.util.List;

public interface IWall extends ILength {
    double getWallWidth();

    boolean isExternal();

    boolean isBearing();

    List<IWall> getInterferenceWalls();
}
