package de.fheger.floorplan2ifc.gui.inputs;

import javafx.scene.control.TextField;

/**
 * Input component for Integers.
 */
public class IntegerNumberField extends TextField {
    public IntegerNumberField() {
        textProperty().addListener((observable, oldValue, newValue) -> {
            for (int c : newValue.toCharArray()) {
                if (c < 48 || c > 57) {
                    setText(oldValue);
                }
            }
            if (newValue.chars().filter(c -> c == '.').count() > 1) {
                setText(oldValue);
            }
        });
    }
}
