package de.fheger.floorplan2ifc.gui.menubar;

import com.buildingsmart.tech.ifc.IfcKernel.IfcProject;
import de.fheger.floorplan2ifc.data.DataCommands;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.logic.LogicCommands;
import de.fheger.floorplan2ifc.logic.ParseToIfcException;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.control.MenuItem;


@Component
public class FileMenu extends Menu {

    private LogicCommands logicCommands;
    private DataCommands dataCommands;

    @Autowired
    public FileMenu(LogicCommands logicCommands, DataCommands dataCommands) {
        super("File");
        this.logicCommands = logicCommands;
        this.dataCommands = dataCommands;

        MenuItem newFile = new MenuItem("New File");
        newFile.setOnAction(e -> onNewFile());

        MenuItem parse = new MenuItem("Parse To Ifc");
        parse.setOnAction(e -> onParseToIfc());

        MenuItem save = new MenuItem("Save to Graph Database");
        save.setOnAction(e -> onSaveToDatabase());

        getItems().add(newFile);
        getItems().add(parse);
        getItems().add(save);
    }

    private void onSaveToDatabase() {
        try {
            IfcProject ifcProject = logicCommands.parseToIfcCommand(ProjectNode.getCurrentProject());
            dataCommands.saveToDatabase(ifcProject);
        } catch (ParseToIfcException e) {
            showAlert(Alert.AlertType.ERROR, "Error during parsing: ", e.getMessage());
        }
    }

    private void onNewFile() {
        throw new RuntimeException("Not implemented yet.");
    }

    private void onParseToIfc() {
        try {
            IfcProject ifcProject = logicCommands.parseToIfcCommand(ProjectNode.getCurrentProject());
            showAlert(Alert.AlertType.INFORMATION, "Parsing succeeded.", "Parsing succeeded without errors. IfcProject " + ifcProject.getName().getValue() + " can be saved into the graph database.");
        } catch (ParseToIfcException e) {
            showAlert(Alert.AlertType.ERROR, "Error during parsing: ", e.getMessage());
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
