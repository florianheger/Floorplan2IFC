package de.fheger.floorplan2ifc.gui.menubar;

import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.logic.commands.LogicCommands;
import de.fheger.floorplan2ifc.logic.exceptions.ParseToIfcException;
import de.fheger.floorplan2ifc.models.entities.root.objectdefinition.context.IfcProject;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FileMenu extends Menu {

    private final LogicCommands logicCommands;

    @Autowired
    public FileMenu(LogicCommands logicCommands) {
        super("File");
        this.logicCommands = logicCommands;
//        this.dataCommands = dataCommands;

        MenuItem newFile = new MenuItem("New File");
        newFile.setOnAction(e -> onNewFile());

        MenuItem parse = new MenuItem("Parse To Ifc");
        parse.setOnAction(e -> onParseToIfc());

        MenuItem save = new MenuItem("Save to Graph Database");
        save.setOnAction(e -> onSaveToDatabase());

        MenuItem test = new MenuItem("Test");
        test.setOnAction(e -> test());

        getItems().add(newFile);
        getItems().add(parse);
        getItems().add(save);
    }

    private void test() {

    }

    private void onSaveToDatabase() {
//        try {
//            IfcProject ifcProject = logicCommands.parseToIfcCommand(ProjectNode.getCurrentProject());
//            dataCommands.saveToDatabase(ifcProject);
//            showAlert(Alert.AlertType.INFORMATION, "Successfully saved to database", "Saving to Database succeeded without errors.");
//        } catch (ParseToIfcException e) {
//            showAlert(Alert.AlertType.ERROR, "Error during parsing", e.getMessage());
//        } catch (SaveToDBException e) {
//            showAlert(Alert.AlertType.ERROR, "Error during saving to database", e.getMessage());
//            throw new RuntimeException(e);
//        }
    }

    private void onNewFile() {
        throw new RuntimeException("Not implemented yet.");
    }

    private void onParseToIfc() {
        try {
            IfcProject ifcProject = logicCommands.parseToIfcCommand(ProjectNode.getCurrentProject());
            showAlert(Alert.AlertType.INFORMATION, "Parsing succeeded", "Parsing succeeded without errors. IfcProject " + ifcProject.getName() + " can be saved into the graph database.");
        } catch (ParseToIfcException e) {
            showAlert(Alert.AlertType.ERROR, "Error during parsing", e.getMessage());
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
