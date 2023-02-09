package de.fheger.floorplan2ifc.gui;

import com.buildingsmart.tech.ifc.IfcKernel.IfcProject;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.logic.LogicCommands;
import de.fheger.floorplan2ifc.logic.ParseToIfcException;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuBar extends javafx.scene.control.MenuBar {

    private LogicCommands logicCommands;

    private IfcProject ifcProject;

    @Autowired
    public MenuBar(LogicCommands logicCommands) {
        super();
        this.logicCommands = logicCommands;
        Menu file = new Menu("File");
        getMenus().add(file);
        MenuItem save = new MenuItem("Parse To Ifc");
        file.getItems().add(save);
        file.setOnAction(e -> onParseToIfc());
    }

    private void onParseToIfc() {
        try {
            ifcProject = logicCommands.parseToIfcCommand(ProjectNode.getCurrentProject());
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
