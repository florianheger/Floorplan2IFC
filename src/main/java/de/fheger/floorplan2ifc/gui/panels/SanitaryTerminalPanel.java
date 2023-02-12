package de.fheger.floorplan2ifc.gui.panels;

import de.fheger.floorplan2ifc.gui.ElementPanel;
import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.MultiSelect;

public class SanitaryTerminalPanel extends ElementPanel {

    private final MultiSelect typeSelect = new MultiSelect();

    public String getSelectedType() {
        return typeSelect.getSelectedElements().get(0); // TODO Fehler?
    }

    public SanitaryTerminalPanel() {
        super("Sanitary Terminal");

        typeSelect.getItems().addAll("BATH", "BIDET", "CISTERN", "SHOWER", "SINK", "SANITARYFOUNTAIN", "TOILETPAN", "URINAL", "WASHHANDBASIN", "WCSEAT", "USERDEFINED", "NOTDEFINED");
        int rowIndex = 0;

        addNode(UiFactory.createStandardLabel("Type"), 0, rowIndex);
        addNode(typeSelect, 1, rowIndex);
    }
}
