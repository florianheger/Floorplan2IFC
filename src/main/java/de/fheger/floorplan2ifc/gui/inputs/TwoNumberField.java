package de.fheger.floorplan2ifc.gui.inputs;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class TwoNumberField extends BorderPane {
    private NumberField numberField1;
    private NumberField numberfield2;

    public TwoNumberField(NumberField numberField1, NumberField numberfield2) {
        super();
        this.numberField1 = numberField1;
        this.numberfield2 = numberfield2;

        Insets insets = new Insets(0, 20, 0, 25);
//        numberfield2.setPadding(insets);

//        add(numberField1, 0, 0);
//        add(numberfield2, 1, 0);
        setLeft(numberField1);
        setRight(numberfield2);
    }

    public double getValue1() {
        return numberField1.getInt();
    }

    public double getValue2() {
        return numberfield2.getInt();
    }
}
