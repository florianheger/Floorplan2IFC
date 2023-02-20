package de.fheger.floorplan2ifc.gui.inputs;

import javafx.scene.layout.BorderPane;

public class TwoNumberField extends BorderPane {
    private final NumberField numberField1;
    private final NumberField numberfield2;

    public TwoNumberField(NumberField numberField1, NumberField numberfield2) {
        super();
        this.numberField1 = numberField1;
        this.numberfield2 = numberfield2;
        setLeft(numberField1);
        setRight(numberfield2);
    }

    public double getValue1() {
        return numberField1.getValue();
    }

    public double getValue2() {
        return numberfield2.getValue();
    }
}
