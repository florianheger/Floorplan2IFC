package de.fheger.floorplan2ifc;

import de.fheger.floorplan2ifc.gui.Floorplan2IfcGUI;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Floorplan2IfcApplication {

    public static void main(String[] args) {
        Application.launch(Floorplan2IfcGUI.class, args);
    }

}
