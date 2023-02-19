package de.fheger.floorplan2ifc.gui.panels.placement.length;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.NumberField;
import de.fheger.floorplan2ifc.gui.panels.placement.EntityPanelWithPlacement;

public class EntityPanelWithLength extends EntityPanelWithPlacement {

    private final NumberField length = UiFactory.createStandardNumberField();

    public int getEntityWidth() {
        return length.getLength();
    }

    public EntityPanelWithLength(String defaultName) {
        super(defaultName);

        gridPane.add(UiFactory.createStandardLabel("Length"), 0, ++rowsInEntityPanel);
        gridPane.add(length, 1, rowsInEntityPanel);
    }
}