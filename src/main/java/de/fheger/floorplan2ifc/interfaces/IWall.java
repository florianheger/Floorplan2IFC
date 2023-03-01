package de.fheger.floorplan2ifc.interfaces;

import java.util.List;

public interface IWall extends IDimension {
    boolean isExternal();

    boolean isBearing();

    List<IWall> getInterferenceWalls();
}
