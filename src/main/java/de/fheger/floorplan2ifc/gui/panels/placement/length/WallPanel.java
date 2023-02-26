package de.fheger.floorplan2ifc.gui.panels.placement.length;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.entityinterfaces.IWall;
import de.fheger.floorplan2ifc.gui.inputs.BoolSelect;
import de.fheger.floorplan2ifc.gui.inputs.EntityMultiSelect;
import de.fheger.floorplan2ifc.gui.inputs.NumberField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WallPanel extends EntityPanelWithLength implements IWall {

    private static final ObservableList<WallPanel> walls = FXCollections.observableArrayList();

    public static ObservableList<WallPanel> getWalls() {
        return walls;
    }

    private final NumberField width = UiFactory.createStandardNumberField();
    private final BoolSelect isExternal = UiFactory.createStandardBoolSelect();
    private final BoolSelect isBearing = UiFactory.createStandardBoolSelect();
    private final EntityMultiSelect<WallPanel> interferences = new EntityMultiSelect<>(Collections.singletonList(walls));

    public WallPanel() {
        super("Wall", 0);
        walls.add(this);

        gridPane.add(UiFactory.createStandardLabel("Width (cm):"), 0, ++rowsInEntityPanel);
        gridPane.add(width, 1, rowsInEntityPanel);

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
    public double getWallWidth() {
        return width.getValue();
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
}
