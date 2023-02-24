package de.fheger.floorplan2ifc.gui.panels.placement.length;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.NumberField;
import de.fheger.floorplan2ifc.gui.panels.placement.EntityPanelWithPlacement;

public abstract class EntityPanelWithLength extends EntityPanelWithPlacement {

    private final NumberField length = UiFactory.createStandardNumberField();

    public int getEntityLength() {
        return length.getLength();
    }

    public EntityPanelWithLength(String defaultName, double defaultPositionY) {
        super(defaultName, defaultPositionY);

        gridPane.add(UiFactory.createStandardLabel("Length (cm):"), 0, ++rowsInEntityPanel);
        gridPane.add(length, 1, rowsInEntityPanel);
    }
}
