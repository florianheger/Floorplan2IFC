package de.fheger.floorplan2ifc.gui.inputs;

import javafx.scene.control.TextField;

public class NumberField extends TextField {
    public NumberField() {
        textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    public int getInt() {
        try {
            return Integer.parseInt(getText());
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
