package de.fheger.floorplan2ifc.gui.entityinterfaces;

import de.fheger.floorplan2ifc.gui.panels.placement.SpacePanel;

import java.util.List;

public interface IDoor extends ILength {
    List<SpacePanel> getConnectedSpaces();
}
