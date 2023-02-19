package de.fheger.floorplan2ifc.gui.panels.placement.length;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.BoolSelect;
import de.fheger.floorplan2ifc.gui.inputs.EntityMultiSelect;
import de.fheger.floorplan2ifc.gui.inputs.NumberField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class WallPanel extends EntityPanelWithLength {

    private static final ObservableList<WallPanel> walls = FXCollections.observableArrayList();

    public static ObservableList<WallPanel> getWalls() {
        return walls;
    }

    private final NumberField width = UiFactory.createStandardNumberField();
    private final BoolSelect isExternal = UiFactory.createStandardBoolSelect();
    private final BoolSelect isBearing = UiFactory.createStandardBoolSelect();
    private final EntityMultiSelect<WallPanel> interferences = new EntityMultiSelect<>(walls);

    public int getWallWidth() {
        return width.getInt();
    }

    public boolean isExternal() {
        return isExternal.isTrue();
    }

    public boolean isBearing() {
        return isBearing.isTrue();
    }

    public List<WallPanel> getInterferenceWalls() {
        return interferences.getSelectedPanels();
    }

    public WallPanel() {
        super("Wall");
        walls.add(this);

        gridPane.add(UiFactory.createStandardLabel("Width:"), 0, ++rowsInEntityPanel);
        gridPane.add(width, 1, rowsInEntityPanel);

        gridPane.add(UiFactory.createStandardLabel("Is External?"), 0, ++rowsInEntityPanel);
        gridPane.add(isExternal, 1, rowsInEntityPanel);

        gridPane.add(UiFactory.createStandardLabel("Is Bearing?"), 0, ++rowsInEntityPanel);
        gridPane.add(isBearing, 1, rowsInEntityPanel);

        gridPane.add(UiFactory.createStandardLabel("Interference with:"), 0, ++rowsInEntityPanel);
        gridPane.add(interferences, 1, rowsInEntityPanel);
    }
}