package de.fheger.floorplan2ifc.gui.panels;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.NumberField;

public class WindowPanel extends EntityPanelWithPlacement {

    private final NumberField length = UiFactory.createStandardNumberField();

    public int getWindowLength() {
        return length.getInt();
    }

    public WindowPanel() {
        super("Window");

        gridPane.add(UiFactory.createStandardLabel("Length"), 0, ++rowsInEntityPanel);
        gridPane.add(length, 1, rowsInEntityPanel);
    }
}
