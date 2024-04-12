package be.ugent.objprog.ugentopoly;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.io.InputStream;

public abstract class Card extends AnchorPane{
    protected ImageView everyImage(String fileName){
        try (InputStream input = this.getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/" + fileName)){
            if (input == null) {throw new NullPointerException();}
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);

            imageView.setPreserveRatio(true);

            return imageView;
        } catch (IOException e) { System.err.println("Error " + fileName + " not in assets folder");
        } catch (NullPointerException e){ System.err.println("Error " + fileName + " not found in asserts folder");
        }
        return null;
    }

    protected Label everyLabel(String text){
        Label label = new Label(text);

        label.setAlignment(javafx.geometry.Pos.CENTER);

        label.setWrapText(true);
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        return label;
    }
}
