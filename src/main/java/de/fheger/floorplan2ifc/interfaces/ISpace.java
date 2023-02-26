package de.fheger.floorplan2ifc.interfaces;

import java.util.List;

public interface ISpace extends IPlacement {
    double getFloorArea();

    List<IWall> getBoundedWalls();

    String getFloorAreaDin();
}
