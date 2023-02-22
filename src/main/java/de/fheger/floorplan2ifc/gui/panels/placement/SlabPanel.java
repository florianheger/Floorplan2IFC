package de.fheger.floorplan2ifc.gui.panels.placement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

public class SlabPanel extends EntityPanelWithPlacement {

    @Getter
    private static final ObservableList<SlabPanel> slabs = FXCollections.observableArrayList();

    public SlabPanel() {
        super("Balcony/Terrace", 0);
        slabs.add(this);
    }

    @Override
    public void remove() {
        slabs.remove(this);
    }
}
