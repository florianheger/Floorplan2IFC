package de.fheger.floorplan2ifc.gui.menubar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuBar extends javafx.scene.control.MenuBar {
    @Autowired
    public MenuBar(FileMenu fileMenu) {
        super();
        super.getMenus().add(fileMenu);
    }
}
