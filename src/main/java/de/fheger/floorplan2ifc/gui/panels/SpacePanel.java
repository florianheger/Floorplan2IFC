package de.fheger.floorplan2ifc.gui.panels;

import de.fheger.floorplan2ifc.gui.ElementPanel;
import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.ElementMultiSelect;
import de.fheger.floorplan2ifc.gui.inputs.NumberField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class SpacePanel extends ElementPanel {

    private static final ObservableList<SpacePanel> spaces = FXCollections.observableArrayList();
    public static ObservableList<SpacePanel> getSpaces() { return spaces; }

    private final NumberField floorArea = UiFactory.createStandardNumberField();
    private final ElementMultiSelect<WallPanel> boundedWalls = new ElementMultiSelect<>(WallPanel.getWalls());

    public int getFloorArea() {
        return floorArea.getInt();
    }

    public List<WallPanel> getBoundedWalls() {
        return boundedWalls.getSelectedPanels();
    }

    public SpacePanel() {
        super("Space");
        spaces.add(this);

        int rowIndex = 0;
        addNode(UiFactory.createStandardLabel("Floor Area:"), 0, rowIndex);
        addNode(floorArea, 1, rowIndex);

        rowIndex++;
        addNode(UiFactory.createStandardLabel("Bounded Walls:"), 0, rowIndex);
        addNode(boundedWalls, 1, rowIndex);
    }
}
