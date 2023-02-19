package de.fheger.floorplan2ifc.gui.panels;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.EntityMultiSelect;
import de.fheger.floorplan2ifc.gui.inputs.NumberField;

import java.util.List;

public class DoorPanel extends EntityPanelWithPlacement {

    private final NumberField length = UiFactory.createStandardNumberField();
    private final EntityMultiSelect<SpacePanel> connectedSpaces = new EntityMultiSelect<>(SpacePanel.getSpaces());

    public int getDoorWidth() {
        return length.getLength();
    }
    public List<SpacePanel> getConnectedSpaces() {
        return connectedSpaces.getSelectedPanels();
    }

    public DoorPanel() {
        super("Door");

        gridPane.add(UiFactory.createStandardLabel("Length"), 0, ++rowsInEntityPanel);
        gridPane.add(length, 1, rowsInEntityPanel);

        gridPane.add(UiFactory.createStandardLabel("Connects Spaces"), 0, ++rowsInEntityPanel);
        gridPane.add(connectedSpaces, 1, rowsInEntityPanel);
    }
}
