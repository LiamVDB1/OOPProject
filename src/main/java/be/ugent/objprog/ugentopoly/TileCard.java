package be.ugent.objprog.ugentopoly;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.io.InputStream;

public abstract class TileCard extends AnchorPane {
    public TileCard(){
        super();
        AnchorPane.setTopAnchor(this, 0.0);
        AnchorPane.setLeftAnchor(this, 0.0);
        AnchorPane.setRightAnchor(this, 0.0);
        AnchorPane.setBottomAnchor(this, 0.0);
        this.setPrefWidth(175);
        this.setPrefHeight(275);
    }

    protected Label everyLabel(String text){
        Label label = new Label(text);

        label.setAlignment(javafx.geometry.Pos.CENTER);
        AnchorPane.setLeftAnchor(label, 0.0);
        AnchorPane.setRightAnchor(label, 0.0);

        label.setWrapText(true);
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setPadding(new Insets(0.0, 10.0, 0.0, 10.0));

        return label;
    }

    protected ImageView makeImage(String fileName){
        try (InputStream input = getClass().getResourceAsStream("assets/" + fileName)){
            if (input == null) {throw new NullPointerException();}
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);

            imageView.setPreserveRatio(true);

            return imageView;
        } catch (IOException e) {
            System.err.println("Error railway.png not in assets folder");
        } catch (NullPointerException e){
            System.err.println("Error railway.png not found in asserts folder");
        }
        return null;
    }
}
