package de.fheger.floorplan2ifc.gui.inputs;

import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * Input component for boolean expressions.
 */
public class BoolSelect extends GridPane {

    private final RadioButton rbTrue = new RadioButton("true");
    private final RadioButton rbFalse = new RadioButton("false");

    public BoolSelect() {
        super();
        ToggleGroup toggleGroup = new ToggleGroup();
        rbTrue.setToggleGroup(toggleGroup);
        rbFalse.setToggleGroup(toggleGroup);
        rbFalse.setSelected(true);

        Insets insets = new Insets(0, 20, 0, 25);
        rbFalse.setPadding(insets);

        add(rbTrue, 0, 0);
        add(rbFalse, 1, 0);
    }

    public void setFont(Font font) {
        rbTrue.setFont(font);
        rbFalse.setFont(font);
    }

    public boolean isTrue() {
        return rbTrue.isSelected();
    }
}
