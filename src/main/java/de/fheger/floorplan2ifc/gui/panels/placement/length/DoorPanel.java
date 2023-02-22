package de.fheger.floorplan2ifc.gui.panels.placement.length;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.EntityMultiSelect;
import de.fheger.floorplan2ifc.gui.panels.placement.SpacePanel;

import java.util.List;

public class DoorPanel extends EntityPanelWithLength {
    private final EntityMultiSelect<SpacePanel> connectedSpaces = new EntityMultiSelect<>(SpacePanel.getSpaces());

    public List<SpacePanel> getConnectedSpaces() {
        return connectedSpaces.getSelectedPanels();
    }

    public DoorPanel() {
        super("Door", 0);

        gridPane.add(UiFactory.createStandardLabel("Connects Spaces"), 0, ++rowsInEntityPanel);
        gridPane.add(connectedSpaces, 1, rowsInEntityPanel);
    }
}
