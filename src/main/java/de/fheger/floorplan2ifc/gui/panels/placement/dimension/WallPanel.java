package de.fheger.floorplan2ifc.gui.panels.placement.dimension;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.BoolSelect;
import de.fheger.floorplan2ifc.gui.inputs.EntityMultiSelect;
import de.fheger.floorplan2ifc.gui.inputs.NumberField;
import de.fheger.floorplan2ifc.interfaces.IWall;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WallPanel extends DimensionPanel implements IWall {

    private static final ObservableList<WallPanel> walls = FXCollections.observableArrayList();

    public static ObservableList<WallPanel> getWalls() {
        return walls;
    }

    private final BoolSelect isExternal = UiFactory.createStandardBoolSelect();
    private final BoolSelect isBearing = UiFactory.createStandardBoolSelect();
    private final EntityMultiSelect<WallPanel> interferences = new EntityMultiSelect<>(Collections.singletonList(walls));
    private final NumberField rotation = UiFactory.createStandardNumberField();

    public WallPanel() {
        super("Wall", 0, 240);
        walls.add(this);

        gridPane.add(UiFactory.createStandardLabel("Rotation:"), 0, ++rowsInEntityPanel);
        gridPane.add(rotation, 1, rowsInEntityPanel);

        gridPane.add(UiFactory.createStandardLabel("Is External?"), 0, ++rowsInEntityPanel);
        gridPane.add(isExternal, 1, rowsInEntityPanel);

        gridPane.add(UiFactory.createStandardLabel("Is Bearing?"), 0, ++rowsInEntityPanel);
        gridPane.add(isBearing, 1, rowsInEntityPanel);

        gridPane.add(UiFactory.createStandardLabel("Interference with:"), 0, ++rowsInEntityPanel);
        gridPane.add(interferences, 1, rowsInEntityPanel);
    }

    @Override
    public void remove() {
        walls.remove(this);
    }

    @Override
    public boolean isExternal() {
        return isExternal.isTrue();
    }

    @Override
    public boolean isBearing() {
        return isBearing.isTrue();
    }

    @Override
    public List<IWall> getInterferenceWalls() {
        return new ArrayList<>(interferences.getSelectedPanels());
    }

    @Override
    public double getRotation() {
        return rotation.getValue();
    }
}
