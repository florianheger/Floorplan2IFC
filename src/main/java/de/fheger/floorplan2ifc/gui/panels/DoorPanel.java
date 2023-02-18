package de.fheger.floorplan2ifc.gui.panels;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.EntityMultiSelect;
import de.fheger.floorplan2ifc.gui.inputs.NumberField;

import java.util.List;

public class DoorPanel extends EntityPanel {

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

        int rowIndex = 0;
        addNode(UiFactory.createStandardLabel("Length"), 0, rowIndex);
        addNode(length, 1, rowIndex);

        rowIndex++;
        addNode(UiFactory.createStandardLabel("Connects Spaces"), 0, rowIndex);
        addNode(connectedSpaces, 1, rowIndex);
    }
}
