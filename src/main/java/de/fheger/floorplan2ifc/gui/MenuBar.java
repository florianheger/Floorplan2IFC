package de.fheger.floorplan2ifc.gui;

import com.buildingsmart.tech.ifc.IfcKernel.IfcProject;
import de.fheger.floorplan2ifc.Floorplan2IfcApplication;
import de.fheger.floorplan2ifc.gui.menubar.FileMenu;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.ProjectNode;
import de.fheger.floorplan2ifc.logic.ParseToIfcException;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuBar extends javafx.scene.control.MenuBar {
    @Autowired
    public MenuBar(FileMenu fileMenu) {
        super();
        getMenus().add(fileMenu);
    }
}
