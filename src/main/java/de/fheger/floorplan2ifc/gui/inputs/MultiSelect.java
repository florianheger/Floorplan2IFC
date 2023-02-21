package de.fheger.floorplan2ifc.gui.inputs;

import org.controlsfx.control.CheckComboBox;

import java.util.List;

public class MultiSelect extends CheckComboBox<String> {

    public MultiSelect(List<String> selectableEntities) {
        getItems().addAll(selectableEntities);
    }

    public MultiSelect() {}

    public List<String> getSelectedItems() {
        return getCheckModel().getCheckedItems();
    }
}
