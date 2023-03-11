package de.fheger.floorplan2ifc.gui;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * Panel for an image and an entity name for the EntityTree.
 */
public class ImagePanel extends Pane {

    private final int height = 25;

    private final Text nameText;

    public ImagePanel(String name, String image) {
        HBox pane = new HBox(5);
        pane.setAlignment(Pos.CENTER_LEFT);
        ImageView imageView = new ImageView(new Image(image));
        imageView.setFitHeight(height);
        imageView.setFitWidth(height);
        pane.getChildren().add(imageView);
        nameText = UiFactory.createH2Headline(name);
        nameText.prefHeight(height);
        pane.getChildren().add(nameText);
        getChildren().add(pane);
    }

    public void updateName(String newName) {
        nameText.setText(newName);
    }
}
