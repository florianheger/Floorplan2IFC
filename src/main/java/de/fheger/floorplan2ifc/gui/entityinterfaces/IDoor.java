package de.fheger.floorplan2ifc.gui.entityinterfaces;

import java.util.List;

public interface IDoor extends ILength {
    List<ISpace> getConnectedSpaces();
}
