package de.fheger.floorplan2ifc.gui.panels;

import de.fheger.floorplan2ifc.gui.ElementPanel;
import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.NumberField;

public class WindowPanel extends ElementPanel {

    private final NumberField length = UiFactory.createStandardNumberField();

    public int getWindowLength() {
        return length.getInt();
    }

    public WindowPanel() {
        super("Window");

        int rowIndex = 0;
        addNode(UiFactory.createStandardLabel("Length"), 0, rowIndex);
        addNode(length, 1, rowIndex);
    }
}
