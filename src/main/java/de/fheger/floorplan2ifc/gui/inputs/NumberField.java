package de.fheger.floorplan2ifc.gui.inputs;

import javafx.scene.control.TextField;

public class NumberField extends TextField {
    public NumberField() {
        textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            for (int c : newValue.toCharArray()) {
                if ((c < 48 || c > 57) && c != '.') {
                    setText(oldValue);
                }
            }
            if (newValue.chars().filter(c -> c == '.').count() > 1) {
                setText(oldValue);
            }
        });
    }

    public double getValue() {
        if (getText().equals("")) {
            return 0;
        }
        try {
            return Double.parseDouble(getText());
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
