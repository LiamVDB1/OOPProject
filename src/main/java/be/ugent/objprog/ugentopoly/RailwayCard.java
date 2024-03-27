package be.ugent.objprog.ugentopoly;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.io.InputStream;

public class RailwayCard extends TileCard{
    private Railway railway;

    public RailwayCard(Railway railway){
        super();
        this.railway = railway;
        initalizeUI();
    }

    public void initalizeUI(){
        ImageView image = makeImage();
        //Label naam = everyLabel(railway.getId());
        Label naam = everyLabel("Rtest");
        AnchorPane.setTopAnchor(naam, 140.0);

        //Label kostprijs = everyLabel("Kostprijs: € " + railway.getCost());
        Label kostprijs = everyLabel("Kostprijs: € " + 100);
        AnchorPane.setTopAnchor(kostprijs, 200.0);


        this.getChildren().addAll(image, naam, kostprijs);
    }

    private ImageView makeImage(){
        try (InputStream input = getClass().getResourceAsStream("assets/railway.png")){
            if (input == null) {throw new NullPointerException();}
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);

            imageView.setPreserveRatio(true);
            imageView.setFitWidth(100);

            AnchorPane.setTopAnchor(imageView, 20.0);
            AnchorPane.setLeftAnchor(imageView, 37.5);
            AnchorPane.setRightAnchor(imageView, 37.5);

            return imageView;
        } catch (IOException e) {
            System.err.println("Error railway.png not in assets folder");
        } catch (NullPointerException e){
            System.err.println("Error railway.png not found in asserts folder");
        }
        return null;
    }


}
