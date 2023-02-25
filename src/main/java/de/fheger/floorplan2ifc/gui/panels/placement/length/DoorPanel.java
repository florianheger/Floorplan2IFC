package de.fheger.floorplan2ifc.gui.panels.placement.length;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.entityinterfaces.IDoor;
import de.fheger.floorplan2ifc.gui.inputs.EntityMultiSelect;
import de.fheger.floorplan2ifc.gui.panels.placement.SpacePanel;

import java.util.Collections;
import java.util.List;

public class DoorPanel extends EntityPanelWithLength implements IDoor {
    private final EntityMultiSelect<SpacePanel> connectedPanels = new EntityMultiSelect<>(Collections.singletonList(SpacePanel.getSpaces()));

    public DoorPanel() {
        super("Door", 0);

        gridPane.add(UiFactory.createStandardLabel("Connects Spaces"), 0, ++rowsInEntityPanel);
        gridPane.add(connectedPanels, 1, rowsInEntityPanel);
    }

    @Override
    public List<SpacePanel> getConnectedSpaces() {
        return connectedPanels.getSelectedPanels();
    }
}
