package de.fheger.floorplan2ifc.gui.panels;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.EntityMultiSelect;
import de.fheger.floorplan2ifc.gui.inputs.NumberField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class SpacePanel extends EntityPanelWithPlacement {

    private static final ObservableList<SpacePanel> spaces = FXCollections.observableArrayList();
    public static ObservableList<SpacePanel> getSpaces() { return spaces; }

    private final NumberField floorArea = UiFactory.createStandardNumberField();
    private final EntityMultiSelect<WallPanel> boundedWalls = new EntityMultiSelect<>(WallPanel.getWalls());

    public int getFloorArea() {
        return floorArea.getInt();
    }

    public List<WallPanel> getBoundedWalls() {
        return boundedWalls.getSelectedPanels();
    }

    public SpacePanel() {
        super("Space");
        spaces.add(this);

        gridPane.add(UiFactory.createStandardLabel("Floor Area:"), 0, ++rowsInEntityPanel);
        gridPane.add(floorArea, 1, rowsInEntityPanel);

        gridPane.add(UiFactory.createStandardLabel("Bounded Walls:"), 0, ++rowsInEntityPanel);
        gridPane.add(boundedWalls, 1, rowsInEntityPanel);
    }
}
