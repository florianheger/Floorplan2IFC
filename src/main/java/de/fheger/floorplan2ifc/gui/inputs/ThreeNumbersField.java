package de.fheger.floorplan2ifc.gui.inputs;

import de.fheger.floorplan2ifc.gui.UiFactory;
import javafx.scene.layout.FlowPane;

public class ThreeNumbersField extends FlowPane {

    private final NumberField numberField1 = UiFactory.createStandardShortNumberField();
    private final NumberField numberField2 = UiFactory.createStandardShortNumberField();
    private final NumberField numberField3 = UiFactory.createStandardShortNumberField();

    public ThreeNumbersField() {
        getChildren().add(numberField1);
        getChildren().add(numberField2);
        getChildren().add(numberField3);
    }

    public void setDefaultValue1(double defaultValue) {
        numberField1.setText(defaultValue + "");
    }

    public void setDefaultValue2(double defaultValue) {
        numberField2.setText(defaultValue + "");
    }

    public void setDefaultValue3(double defaultValue) {
        numberField3.setText(defaultValue + "");
    }

    public double getValue1() {
        return numberField1.getValue();
    }

    public double getValue2() {
        return numberField2.getValue();
    }

    public double getValue3() {
        return numberField3.getValue();
    }
}
