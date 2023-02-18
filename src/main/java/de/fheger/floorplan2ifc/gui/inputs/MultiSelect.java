package de.fheger.floorplan2ifc.gui.inputs;

import org.controlsfx.control.CheckComboBox;

import java.util.List;

public class MultiSelect extends CheckComboBox<String> {

    public MultiSelect(List<String> selectableEntities) {
        selectableEntities.forEach(e -> getItems().add(e));
    }

    public MultiSelect() {}

    public List<String> getSelectedEntities() {
        return getCheckModel().getCheckedItems();
    }
}
