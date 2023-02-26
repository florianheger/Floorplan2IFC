package de.fheger.floorplan2ifc.gui.panels.placement;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.interfaces.IPlacement;
import de.fheger.floorplan2ifc.gui.inputs.ThreeNumbersField;
import de.fheger.floorplan2ifc.gui.panels.EntityPanel;

public abstract class EntityPanelWithPlacement extends EntityPanel implements IPlacement {

    private final ThreeNumbersField positionField = UiFactory.createStandardThreeNumbersField();

    public EntityPanelWithPlacement(String defaultName, double defaultPositionY) {
        super(defaultName);

        positionField.setDefaultValue2(defaultPositionY);

        gridPane.add(UiFactory.createStandardLabel("Position (cm):"), 0, ++rowsInEntityPanel);
        gridPane.add(positionField, 1, rowsInEntityPanel);
    }

    @Override
    public double getPositionX() {
        return positionField.getValue1();
    }
    @Override
    public double getPositionY() {
        return positionField.getValue2();
    }
    @Override
    public double getPositionZ() {
        return positionField.getValue3();
    }
}
