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
        ImageView image = makeImage("railway.png");

        image.setFitWidth(100);
        AnchorPane.setTopAnchor(image, 20.0);
        AnchorPane.setLeftAnchor(image, 37.5);
        AnchorPane.setRightAnchor(image, 37.5);

        Label naam = everyLabel(railway.getText());
        AnchorPane.setTopAnchor(naam, 140.0);

        Label kostprijs = everyLabel("Kostprijs: € " + railway.getCost());
        AnchorPane.setTopAnchor(kostprijs, 225.0);

        Label huur = everyLabel("Huur: € " + railway.getRent());
        AnchorPane.setTopAnchor(huur, 190.0);

        this.getChildren().addAll(image, naam, huur, kostprijs);
    }

}
