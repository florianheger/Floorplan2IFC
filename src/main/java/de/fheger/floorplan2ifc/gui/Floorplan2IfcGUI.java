package de.fheger.floorplan2ifc.gui;

import de.fheger.floorplan2ifc.Floorplan2IfcApplication;
import de.fheger.floorplan2ifc.gui.menubar.MenuBar;
import de.fheger.floorplan2ifc.gui.nodes.BuildingNode;
import de.fheger.floorplan2ifc.gui.nodes.BuildingStoreyNode;
import de.fheger.floorplan2ifc.gui.nodes.ProjectNode;
import de.fheger.floorplan2ifc.gui.nodes.SiteNode;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Floorplan2IfcGUI extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(Floorplan2IfcApplication.class).run();
    }

    @Override
    public void start(Stage primaryStage) {
        Pane mainPane = createMainPane();
        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Floorplan2IFC");
        primaryStage.getIcons().add(new Image("/icons/Floorplan.png"));
        primaryStage.setMinWidth(800);
        primaryStage.setMaximized(true);
        primaryStage.setOnCloseRequest(e -> stop());
        primaryStage.show();
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    private Pane createMainPane() {
        Pane entityPane = new Pane();
        ProjectNode projectNode = createStartCase();
        EntityTree tree = new EntityTree(projectNode, entityPane);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(entityPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        BorderPane borderPane = new BorderPane();

        MenuBar menuBar = applicationContext.getBean(MenuBar.class);

        borderPane.setTop(menuBar);
        borderPane.setLeft(tree);
        borderPane.setCenter(scrollPane);

        return borderPane;
    }

    private ProjectNode createStartCase() {
        ProjectNode projectNode = new ProjectNode();
        SiteNode siteNode = new SiteNode();
        projectNode.getChildren().add(siteNode);
        BuildingNode buildingNode = new BuildingNode();
        siteNode.getChildren().add(buildingNode);
        BuildingStoreyNode buildingStoreyNode = new BuildingStoreyNode();
        buildingNode.getChildren().add(buildingStoreyNode);

        return projectNode;
    }
}
