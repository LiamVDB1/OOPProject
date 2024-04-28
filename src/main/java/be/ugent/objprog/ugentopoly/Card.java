package be.ugent.objprog.ugentopoly;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.io.InputStream;

public abstract class Card extends AnchorPane{
    protected ImageView everyImage(Image image){
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        return imageView;
    }

    protected Label everyLabel(String text){
        Label label = new Label(text);

        label.setAlignment(javafx.geometry.Pos.CENTER);

        label.setWrapText(true);
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        return label;
    }

    protected Image imageCreate(String fileName){
        try (InputStream input = this.getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/" + fileName)){
            if (input == null) {throw new NullPointerException();}
            return new Image(input);
        } catch (IOException e) { System.err.println("Error " + fileName + " not in assets folder");
        } catch (NullPointerException e){ System.err.println("Error " + fileName + " not found in assets folder");
        }
        return null;
    }

    //Label "W"ith Anchors
    protected Label labelWAnchors(String text, Double topAnchor, Double leftAnchor, Double rightAnchor, Double bottomAnchor){
        Label label = everyLabel(text);
        AnchorPane.setTopAnchor(label, topAnchor);
        AnchorPane.setLeftAnchor(label, leftAnchor);
        AnchorPane.setRightAnchor(label, rightAnchor);
        AnchorPane.setBottomAnchor(label, bottomAnchor);
        return label;
    }
    //Image "W"ith Anchors
    protected ImageView imageViewWAnchors(Image image, Double topAnchor, Double leftAnchor, Double rightAnchor, Double bottomAnchor){
        ImageView imageView = everyImage(image);
        AnchorPane.setTopAnchor(imageView, topAnchor);
        AnchorPane.setLeftAnchor(imageView, leftAnchor);
        AnchorPane.setRightAnchor(imageView, rightAnchor);
        AnchorPane.setBottomAnchor(imageView, bottomAnchor);
        return imageView;
    }
}
