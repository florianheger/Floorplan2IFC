package de.fheger.floorplan2ifc.gui.panels.placement.dimension;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.gui.inputs.ThreeNumbersField;
import de.fheger.floorplan2ifc.interfaces.IDimension;
import de.fheger.floorplan2ifc.gui.panels.placement.PlacementPanel;

public abstract class DimensionPanel extends PlacementPanel implements IDimension {

    private final ThreeNumbersField dimensions = UiFactory.createStandardThreeNumbersField();

    public DimensionPanel(String defaultName, double defaultPositionY, double defaultHeight) {
        super(defaultName, defaultPositionY);

        dimensions.setDefaultValue3(defaultHeight);

        gridPane.add(UiFactory.createStandardLabel("Dimensions (l/w/h in cm):"), 0, ++rowsInEntityPanel);
        gridPane.add(dimensions, 1, rowsInEntityPanel);
    }

    @Override
    public double getDimensionLength() {
        return dimensions.getValue1();
    }

    @Override
    public double getDimensionWidth() {
        return dimensions.getValue2();
    }

    @Override
    public double getDimensionHeight() {
        return dimensions.getValue3();
    }
}
