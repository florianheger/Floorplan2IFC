package de.fheger.floorplan2ifc.gui;

import de.fheger.floorplan2ifc.Floorplan2IfcApplication;
import de.fheger.floorplan2ifc.gui.nodes.elementnodeswithchilds.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Floorplan2IfcGUI extends Application {

    @Autowired
    private MenuBar menuBar;

    private ConfigurableApplicationContext applicationContext;

    private Pane elementPane;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        applicationContext = new SpringApplicationBuilder(Floorplan2IfcApplication.class).run(args);
    }

    @Override
    public void start(Stage primaryStage) {
//        applicationContext.publishEvent(new StageReadyEvent(primaryStage));

        Pane mainPane = createMainPane();
        Scene scene = new Scene(mainPane, 700, 450);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Floorplan2IFC");
        primaryStage.show();
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    private Pane createMainPane() {
        ProjectNode projectNode = new ProjectNode();
        SiteNode siteNode = new SiteNode();
        projectNode.getChildren().add(siteNode);
        BuildingNode buildingNode = new BuildingNode();
        siteNode.getChildren().add(buildingNode);
        BuildingStoreyNode buildingStoreyNode = new BuildingStoreyNode();
        buildingNode.getChildren().add(buildingStoreyNode);
        WallNode wallNode = new WallNode();
        buildingStoreyNode.getChildren().add(wallNode);

        elementPane = new Pane();
        ElementTree tree = new ElementTree(projectNode, elementPane);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(elementPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new MenuBar());
        borderPane.setLeft(tree);
        borderPane.setCenter(scrollPane);

        return borderPane;
    }

    public static void main(String[] args) {
        launch();
    }
    static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }
    }
}