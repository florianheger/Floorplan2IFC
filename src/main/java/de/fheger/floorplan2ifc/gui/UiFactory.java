package de.fheger.floorplan2ifc.gui;

import de.fheger.floorplan2ifc.gui.inputs.BoolSelect;
import de.fheger.floorplan2ifc.gui.inputs.NumberField;
import de.fheger.floorplan2ifc.gui.inputs.TwoNumberField;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class UiFactory {

    public static final int FONT_SIZE_STANDARD = 12;
    public static final int FONT_SIZE_H1HEADLINE = 20;
    public static final int FONT_SIZE_H2HEADLINE = 15;

    public static final String FONT_FAMILY = "Tahoma";

    public static Font FONT_STANDARD = Font.font(FONT_FAMILY, FontWeight.NORMAL, FONT_SIZE_STANDARD);
    public static Font FONT_H1HEADLINE = Font.font(FONT_FAMILY, FontWeight.BOLD, FONT_SIZE_H1HEADLINE);
    public static Font FONT_H2HEADLINE = Font.font(FONT_FAMILY, FontWeight.NORMAL, FONT_SIZE_H2HEADLINE);

    public static Text createH1Headline(String s) {
        Text text = new Text(s);
        text.setFont(FONT_H1HEADLINE);
        return text;
    }

    public static Text createH2Headline(String s) {
        Text text = new Text(s);
        text.setFont(FONT_H2HEADLINE);
        return text;
    }

    public static Label createStandardLabel(String s) {
        Label label = new Label(s);
        label.setFont(FONT_STANDARD);
        return label;
    }

    public static TextField createStandardTextField() {
        TextField textField = new TextField();
        textField.setFont(FONT_STANDARD);
        return textField;
    }

    public static TextArea createStandardTextArea() {
        TextArea textArea = new TextArea();
        textArea.setFont(FONT_STANDARD);
        return textArea;
    }

    public static NumberField createStandardNumberField() {
        NumberField numberField = new NumberField();
        numberField.setFont(FONT_STANDARD);
        return numberField;
    }

    public static BoolSelect createStandardBoolSelect() {
        BoolSelect boolSelect = new BoolSelect();
        boolSelect.setFont(FONT_STANDARD);
        return boolSelect;
    }

    public static TwoNumberField createStandardTwoNumberField() {
        return new TwoNumberField(createStandardNumberField(), createStandardNumberField());
    }
}
