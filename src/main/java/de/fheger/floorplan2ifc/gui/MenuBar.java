package de.fheger.floorplan2ifc.gui;

import de.fheger.floorplan2ifc.gui.menubar.FileMenu;
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
