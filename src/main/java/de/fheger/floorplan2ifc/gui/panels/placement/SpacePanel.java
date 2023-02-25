package de.fheger.floorplan2ifc.gui.panels.placement;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.entityinterfaces.ISpace;
import de.fheger.floorplan2ifc.gui.inputs.EntityMultiSelect;
import de.fheger.floorplan2ifc.gui.inputs.MultiSelect;
import de.fheger.floorplan2ifc.gui.inputs.NumberField;
import de.fheger.floorplan2ifc.gui.panels.placement.length.WallPanel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpacePanel extends EntityPanelWithPlacement implements ISpace {

    private static final ObservableList<SpacePanel> spaces = FXCollections.observableArrayList();

    public static ObservableList<SpacePanel> getSpaces() {
        return spaces;
    }

    private final NumberField floorArea = UiFactory.createStandardNumberField();
    private final EntityMultiSelect<WallPanel> boundedWalls = new EntityMultiSelect<>(Collections.singletonList(WallPanel.getWalls()));
    private final MultiSelect floorAreaDin = new MultiSelect(Arrays.asList("NUF 1: Wohnen und Aufenthalt", "NUF 2: Büroarbeit", "NUF 3: Produktion, Hand- und Maschinenarbeit, Forschung und Entwicklung (vormals „Experimente“)", "NUF 4: Lagern, Verteilen und Verkaufen", "NUF 5: Bildung, Unterricht und Kultur", "NUF 6: Heilen und Pflegen", "NUF 7: Sonstige Nutzungen (vormals „Sonstige Nutzflächen“)"));

    public SpacePanel() {
        super("Space", 0);
        spaces.add(this);

        gridPane.add(UiFactory.createStandardLabel("Floor Area (m²):"), 0, ++rowsInEntityPanel);
        gridPane.add(floorArea, 1, rowsInEntityPanel);

        gridPane.add(UiFactory.createStandardLabel("Bounded Walls:"), 0, ++rowsInEntityPanel);
        gridPane.add(boundedWalls, 1, rowsInEntityPanel);

        gridPane.add(UiFactory.createStandardLabel("Floor Area (DIN 277):"), 0, ++rowsInEntityPanel);
        gridPane.add(floorAreaDin, 1, rowsInEntityPanel);
    }

    @Override
    public void remove() {
        spaces.remove(this);
    }

    @Override
    public double getFloorArea() {
        return floorArea.getValue();
    }
    @Override
    public List<WallPanel> getBoundedWalls() {
        return boundedWalls.getSelectedPanels();
    }
    @Override
    public String getFloorAreaDin() {
        if (floorAreaDin.getSelectedItems().size() == 0) {
            return null;
        }
        return floorAreaDin.getSelectedItems().get(0);
    }
}
