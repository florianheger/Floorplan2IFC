package de.fheger.floorplan2ifc.gui.panels.placement;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.IntegerNumberField;

public class BuildingStoreyPanel extends EntityPanelWithPlacement {

    private final IntegerNumberField floorNumber = UiFactory.createStandardIntegerNumberField();

    public BuildingStoreyPanel() {
        super("Storey", 0);

        gridPane.add(UiFactory.createStandardLabel("Floor number:"), 0, ++rowsInEntityPanel);
        gridPane.add(floorNumber, 1, rowsInEntityPanel);
    }
}
