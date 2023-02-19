package de.fheger.floorplan2ifc.gui.panels;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.TwoNumberField;

public abstract class EntityPanelWithPlacement extends EntityPanel {

    private final TwoNumberField positionField = UiFactory.createStandardTwoNumberField();

    public double getPositionX() {
        return positionField.getValue1();
    }
    public double getPositionY() {
        return positionField.getValue2();
    }

    public EntityPanelWithPlacement(String defaultName) {
        super(defaultName);

        gridPane.add(UiFactory.createStandardLabel("Position:"), 0, ++rowsInEntityPanel);
        gridPane.add(positionField, 1, rowsInEntityPanel);
    }
}
