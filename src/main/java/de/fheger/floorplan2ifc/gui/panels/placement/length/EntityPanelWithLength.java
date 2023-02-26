package de.fheger.floorplan2ifc.gui.panels.placement.length;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.interfaces.ILength;
import de.fheger.floorplan2ifc.gui.inputs.NumberField;
import de.fheger.floorplan2ifc.gui.panels.placement.EntityPanelWithPlacement;

public abstract class EntityPanelWithLength extends EntityPanelWithPlacement implements ILength {

    private final NumberField length = UiFactory.createStandardNumberField();

    public EntityPanelWithLength(String defaultName, double defaultPositionY) {
        super(defaultName, defaultPositionY);

        gridPane.add(UiFactory.createStandardLabel("Length (cm):"), 0, ++rowsInEntityPanel);
        gridPane.add(length, 1, rowsInEntityPanel);
    }

    @Override
    public int getEntityLength() {
        return length.getLength();
    }
}
