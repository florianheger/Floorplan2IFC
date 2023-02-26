package de.fheger.floorplan2ifc.gui.panels.placement;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.interfaces.ISanitaryTerminal;
import de.fheger.floorplan2ifc.gui.inputs.MultiSelect;

public class SanitaryTerminalPanel extends EntityPanelWithPlacement implements ISanitaryTerminal {

    private final MultiSelect typeSelect = new MultiSelect();

    public SanitaryTerminalPanel() {
        super("Sanitary Terminal", 0);

        typeSelect.getItems().addAll("BATH", "BIDET", "CISTERN", "SHOWER", "SINK", "SANITARYFOUNTAIN", "TOILETPAN", "URINAL", "WASHHANDBASIN", "WCSEAT", "USERDEFINED", "NOTDEFINED");

        gridPane.add(UiFactory.createStandardLabel("Type"), 0, ++rowsInEntityPanel);
        gridPane.add(typeSelect, 1, rowsInEntityPanel);
    }

    @Override
    public String getSelectedType() {
        return typeSelect.getSelectedItems().get(0);
    }
}
