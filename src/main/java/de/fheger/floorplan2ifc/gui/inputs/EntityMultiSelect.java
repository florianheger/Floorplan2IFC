package de.fheger.floorplan2ifc.gui.inputs;

import de.fheger.floorplan2ifc.gui.panels.EntityPanel;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import org.controlsfx.control.CheckComboBox;

import java.util.List;

/**
 * Select input component for multiple EntityPanels.
 */
public class EntityMultiSelect<PanelType extends EntityPanel> extends CheckComboBox<PanelType> {

    public EntityMultiSelect(List<ObservableList<? extends PanelType>> observableLists) {
        super();
        observableLists.forEach(observableList -> {
            observableList.forEach(p -> getItems().add(p));
            observableList.addListener(this::updateItems);
        });
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
