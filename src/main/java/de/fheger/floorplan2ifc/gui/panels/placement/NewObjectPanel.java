package de.fheger.floorplan2ifc.gui.panels.placement;

import de.fheger.floorplan2ifc.gui.UiFactory;
import de.fheger.floorplan2ifc.interfaces.INewObject;
import javafx.scene.control.TextField;

public class NewObjectPanel extends PlacementPanel implements INewObject {

    private final TextField newAttributeField = UiFactory.createStandardTextField();

    public NewObjectPanel() {
        super("New Object", 0);

        gridPane.add(UiFactory.createStandardLabel("New Attribute:"), 0, ++rowsInEntityPanel);
        gridPane.add(newAttributeField, 1, rowsInEntityPanel);
    }

    @Override
    public String getNewAttribute() {
        return newAttributeField.getText();
    }
}
