package de.fheger.floorplan2ifc.gui.inputs;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ElementMultiSelect<PanelType extends de.fheger.floorplan2ifc.gui.ElementPanel> extends MultiSelect {

    public ElementMultiSelect(ObservableList<PanelType> observableList) {
        super();
        observableList.forEach(p -> getItems().add(p.getNameOrDefault()));
        observableList.addListener((ListChangeListener<de.fheger.floorplan2ifc.gui.ElementPanel>) this::updateItems);
    }

    private void updateItems(ListChangeListener.Change<? extends de.fheger.floorplan2ifc.gui.ElementPanel> change) {
        change.next();
        if (change.getRemovedSize() > 0) {
            for (de.fheger.floorplan2ifc.gui.ElementPanel removed :
                    change.getRemoved()) {
                getItems().remove(removed.getNameOrDefault());
            }
        }
        if (change.getAddedSize() > 0) {
            for (de.fheger.floorplan2ifc.gui.ElementPanel added :
                    change.getAddedSubList()) {
                getItems().add(added.getNameOrDefault());
            }
        }
    }

    public List<PanelType> getSelectedPanels() {
        List<PanelType> selectedElements = new ArrayList<>();
        // TODO finish
        return selectedElements;
    }
}
