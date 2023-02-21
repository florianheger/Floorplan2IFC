package de.fheger.floorplan2ifc.gui.panels;

import de.fheger.floorplan2ifc.gui.UiFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import nl.tue.isbe.ifcspftools.GuidHandler;

public abstract class EntityPanel extends BorderPane {
    protected final GridPane gridPane;

    protected int rowsInEntityPanel = 0;

    private final TextField nameField = UiFactory.createStandardTextField();
    private final TextField globalIdField = UiFactory.createStandardTextField();
    private final TextArea descriptionField = UiFactory.createStandardTextArea();

    public String getName() {
        return nameField.getText();
    }

    public String getGlobalId() {
        return globalIdField.getText();
    }

    public String getDescription() {
        return descriptionField.getText();
    }

    public EntityPanel(String defaultName) {
        super(new ScrollPane());

        setPadding(new Insets(25, 25, 25, 25));
        setTop(UiFactory.createH1Headline(defaultName));

        gridPane = new GridPane();
        setCenter(gridPane);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 0, 25, 0));

        nameField.setText(defaultName);
        globalIdField.setText(GuidHandler.getNewIfcGloballyUniqueId());

        gridPane.add(UiFactory.createH2Headline("Standard Values"), 0, rowsInEntityPanel, 2, 1);

        gridPane.add(UiFactory.createStandardLabel("Name:"), 0, ++rowsInEntityPanel);
        gridPane.add(nameField, 1, rowsInEntityPanel);

        gridPane.add(UiFactory.createStandardLabel("ID:"), 0, ++rowsInEntityPanel);
        gridPane.add(globalIdField, 1, rowsInEntityPanel);

        gridPane.add(UiFactory.createStandardLabel("Description:"), 0, ++rowsInEntityPanel);
        gridPane.add(descriptionField, 0, ++rowsInEntityPanel, 2, 1);

        gridPane.add(UiFactory.createH2Headline(defaultName + " Values"), 0, ++rowsInEntityPanel, 2, 1);
    }

    public void remove() {
    }

    @Override
    public String toString() {
        return getName();
    }

    public void onNameChanged(OnNameChanged onNameChanged) {
        nameField.textProperty().addListener((observable, oldValue, newValue) -> onNameChanged.changeName(newValue));
    }

    public interface OnNameChanged {
        void changeName(String s);
    }
}
