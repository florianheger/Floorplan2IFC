package de.fheger.floorplan2ifc.gui.inputs;

import de.fheger.floorplan2ifc.gui.ElementPanel;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import org.controlsfx.control.CheckComboBox;

import java.util.List;

public class ElementMultiSelect<PanelType extends ElementPanel> extends CheckComboBox<PanelType> {

    public ElementMultiSelect(ObservableList<PanelType> observableList) {
        super();
        observableList.forEach(p -> getItems().add(p));
        observableList.addListener(this::updateItems);
    }

    private void updateItems(ListChangeListener.Change<? extends PanelType> change) {
        change.next();
        if (change.getRemovedSize() > 0) {
            for (PanelType removed :
                    change.getRemoved()) {
                getItems().remove(removed);
            }
        }
        if (change.getAddedSize() > 0) {
            for (PanelType added :
                    change.getAddedSubList()) {
                getItems().add(added);
            }
        }
    }

    public List<PanelType> getSelectedPanels() {
        return getCheckModel().getCheckedItems();
    }
}
