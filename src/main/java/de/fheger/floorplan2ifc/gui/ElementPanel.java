package de.fheger.floorplan2ifc.gui;

import de.fheger.floorplan2ifc.gui.inputs.TwoNumberField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public abstract class ElementPanel extends BorderPane {

    private static int nextId;
    private final int id;

    private final String defaultName;
    private final GridPane gridPane;

    private final int rowsInElementPanel;

    private final TextField nameField = UiFactory.createStandardTextField();
    private final TextField globalIdField = UiFactory.createStandardTextField();
    private final TextArea descriptionField = UiFactory.createStandardTextArea();
    private final TwoNumberField positionField = UiFactory.createStandardTwoNumberField();

    public String getName() {
        return nameField.getText();
    }
    public String getGlobalId() {
        return globalIdField.getText();
    }
    public String getDescription() {
        return descriptionField.getText();
    }
    public double getPositionX() {
        return positionField.getValue1();
    }
    public double getPositionY() {
        return positionField.getValue2();
    }

    public ElementPanel(String defaultName) {
        super(new ScrollPane());
        id = nextId++;

        this.defaultName = defaultName;

        setPadding(new Insets(25, 25, 25, 25));
        setTop(UiFactory.createH1Headline(defaultName));

        gridPane = new GridPane();
        setCenter(gridPane);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 0, 25, 0));

        nameField.setText(defaultName);
//        globalIdField.setText(GuidHandler.getNewIfcGloballyUniqueId());

        int rowIndex = 0;
        gridPane.add(UiFactory.createH2Headline("Standard Values"), 0, rowIndex, 2, 1);

        gridPane.add(UiFactory.createStandardLabel("Name:"), 0, ++rowIndex);
        gridPane.add(nameField, 1, rowIndex);

        gridPane.add(UiFactory.createStandardLabel("ID:"), 0, ++rowIndex);
        gridPane.add(globalIdField, 1, rowIndex);

        gridPane.add(UiFactory.createStandardLabel("Description:"), 0, ++rowIndex);
        gridPane.add(descriptionField, 0, ++rowIndex, 2, 1);

        gridPane.add(UiFactory.createStandardLabel("Position:"), 0, ++rowIndex);
        gridPane.add(positionField, 1, rowIndex);

        gridPane.add(UiFactory.createH2Headline(defaultName + " Values"), 0, ++rowIndex, 2, 1);

        rowsInElementPanel = gridPane.getRowCount();
    }

    protected void addNode(Node node, int columnIndex, int rowIndex) {
        gridPane.add(
                node,
                columnIndex,
                rowIndex + rowsInElementPanel);
    }

    protected void addNode(Node node, int columnIndex, int rowIndex, int colspan, int rowspan) {
        gridPane.add(
                node,
                columnIndex,
                rowIndex + rowsInElementPanel,
                colspan,
                rowspan);
    }

    public String getNameOrDefault() {
        return defaultName + " " + id; // noch aktuellen Namen anpassen
    }
}
