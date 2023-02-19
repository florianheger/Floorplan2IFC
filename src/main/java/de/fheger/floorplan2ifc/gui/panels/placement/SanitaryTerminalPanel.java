package de.fheger.floorplan2ifc.gui.panels.placement;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.MultiSelect;

public class SanitaryTerminalPanel extends EntityPanelWithPlacement {

    private final MultiSelect typeSelect = new MultiSelect();

    public String getSelectedType() {
        return typeSelect.getSelectedEntities().get(0);
    }

    public SanitaryTerminalPanel() {
        super("Sanitary Terminal");

        typeSelect.getItems().addAll("BATH", "BIDET", "CISTERN", "SHOWER", "SINK", "SANITARYFOUNTAIN", "TOILETPAN", "URINAL", "WASHHANDBASIN", "WCSEAT", "USERDEFINED", "NOTDEFINED");

        gridPane.add(UiFactory.createStandardLabel("Type"), 0, ++rowsInEntityPanel);
        gridPane.add(typeSelect, 1, rowsInEntityPanel);
    }
}
