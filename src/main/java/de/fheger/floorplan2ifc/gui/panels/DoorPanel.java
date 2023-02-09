package de.fheger.floorplan2ifc.gui.panels;

import de.fheger.floorplan2ifc.gui.ElementPanel;
import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.ElementMultiSelect;
import de.fheger.floorplan2ifc.gui.inputs.NumberField;

import java.util.List;

public class DoorPanel extends ElementPanel {

    private NumberField length = UiFactory.createStandardNumberField();
    private ElementMultiSelect<SpacePanel> connectedSpaces = new ElementMultiSelect<>(SpacePanel.getSpaces());

    public int getLength() {
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
