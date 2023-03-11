package de.fheger.floorplan2ifc;

import de.fheger.floorplan2ifc.gui.Floorplan2IfcGUI;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * Main class of Floorplan2IFC.
 */
@SpringBootApplication
@EnableNeo4jRepositories
public class Floorplan2IfcApplication {

    public static void main(String[] args) {
        Application.launch(Floorplan2IfcGUI.class, args);
    }
}
