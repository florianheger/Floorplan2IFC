package de.fheger.floorplan2ifc.gui.panels;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.BoolSelect;
import de.fheger.floorplan2ifc.gui.inputs.EntityMultiSelect;
import de.fheger.floorplan2ifc.gui.inputs.NumberField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class WallPanel extends EntityPanel {

    private static final ObservableList<WallPanel> walls = FXCollections.observableArrayList();
    public static ObservableList<WallPanel> getWalls() { return walls; }

    private final NumberField length = UiFactory.createStandardNumberField();
    private final NumberField width = UiFactory.createStandardNumberField();
    private final BoolSelect isExternal = UiFactory.createStandardBoolSelect();
    private final BoolSelect isBearing = UiFactory.createStandardBoolSelect();
    private final EntityMultiSelect<WallPanel> interferences = new EntityMultiSelect<>(walls);

    public int getWallLength() {
        return length.getInt();
    }
    public int getWallWidth() {
        return width.getInt();
    }
    public boolean isExternal() {
        return isExternal.isTrue();
    }
    public boolean isBearing() {
        return isBearing.isTrue();
    }
    public List<WallPanel> getInterfernceWalls() {
        return interferences.getSelectedPanels();
    }

    public WallPanel() {
        super("Wall");
        walls.add(this);

        int rowIndex = 0;
        addNode(UiFactory.createStandardLabel("Length:"), 0, rowIndex);
        addNode(length, 1, rowIndex);

        rowIndex++;
        addNode(UiFactory.createStandardLabel("Width:"), 0, rowIndex);
        addNode(width, 1, rowIndex);

        rowIndex++;
        addNode(UiFactory.createStandardLabel("Is External?"), 0, rowIndex);
        addNode(isExternal, 1, rowIndex);

        rowIndex++;
        addNode(UiFactory.createStandardLabel("Is Bearing?"), 0, rowIndex);
        addNode(isBearing, 1, rowIndex);

        rowIndex++;
        addNode(UiFactory.createStandardLabel("Interference with:"), 0, rowIndex);
        addNode(interferences, 1, rowIndex);
    }
}
