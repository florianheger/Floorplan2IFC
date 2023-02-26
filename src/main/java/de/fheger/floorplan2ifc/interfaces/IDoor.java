package de.fheger.floorplan2ifc.interfaces;

import java.util.List;

public interface IDoor extends ILength {
    List<ISpace> getConnectedSpaces();
}
