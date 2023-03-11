package de.fheger.floorplan2ifc.gui.menubar;

import de.fheger.floorplan2ifc.gui.nodes.ProjectNode;
import de.fheger.floorplan2ifc.logic.commands.LogicCommands;
import de.fheger.floorplan2ifc.logic.exceptions.IfcRuleViolationException;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.logic.exceptions.SaveToDatabaseException;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Menu for all file commands.
 */
@Component
public class FileMenu extends Menu {

    private final LogicCommands logicCommands;

    @Autowired
    public FileMenu(LogicCommands logicCommands) {
        super("File");
        this.logicCommands = logicCommands;

        MenuItem newFile = new MenuItem("New File");
        newFile.setOnAction(e -> onNewFile());

        MenuItem parse = new MenuItem("Check Consistency");
        parse.setOnAction(e -> onCheckConsistency());

        MenuItem save = new MenuItem("Save to Graph Database");
        save.setOnAction(e -> onSaveToDatabase());

        getItems().add(newFile);
        getItems().add(parse);
        getItems().add(save);
    }

    private void onSaveToDatabase() {
        try {
            logicCommands.saveToGraphDatabase(ProjectNode.getCurrentProject().getEntityPanel());
            showAlert(Alert.AlertType.INFORMATION, "Successfully saved to database",
                    "Saving to Database succeeded without errors.");
        } catch (ParseToIfcException e) {
            showAlert(Alert.AlertType.ERROR, "Error during parsing", e.getMessage());
            e.printStackTrace();
        } catch (IfcRuleViolationException e) {
            showAlert(Alert.AlertType.ERROR, "Rule Violation", e.getMessage());
            e.printStackTrace();
        } catch (SaveToDatabaseException e) {
            showAlert(Alert.AlertType.ERROR, "Error during saving to database", e.getMessage());
            e.printStackTrace();
        }
    }

    private void onNewFile() {
        throw new RuntimeException("Not implemented yet.");
    }

    private void onCheckConsistency() {
        try {
            logicCommands.checkRuleViolations(ProjectNode.getCurrentProject().getEntityPanel());
            logicCommands.checkIfProjectIsParsable(ProjectNode.getCurrentProject().getEntityPanel());
            showAlert(Alert.AlertType.INFORMATION, "Project is consistent", "No Rule Violations and parsing " +
                    "succeeded without errors. Project can be saved into the graph database.");
        } catch (IfcRuleViolationException e) {
            showAlert(Alert.AlertType.ERROR, "Rule Violation", e.getMessage());
            e.printStackTrace();
        } catch (ParseToIfcException e) {
            showAlert(Alert.AlertType.ERROR, "Error during parsing to IFC", e.getMessage());
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String text) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
