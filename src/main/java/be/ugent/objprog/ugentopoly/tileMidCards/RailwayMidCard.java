package be.ugent.objprog.ugentopoly.tileMidCards;

import be.ugent.objprog.ugentopoly.tiles.Railway;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class RailwayMidCard extends TileMidCard {
    private Railway railway;

    public RailwayMidCard(Railway railway){
        super();
        this.railway = railway;
        initalizeUI();
    }

    public void initalizeUI(){
        ImageView image = makeImage("railway.png", 100, 30.0, 37.5, 37.5);

        Label naam = makeLabel(railway.getText(), 140.0);

        Label kostprijs = makeLabel("Kostprijs: € " + railway.getCost(), 190.0);

        Label huur = makeLabel("Huur: € " + railway.getRent(), 225.0);

        this.getChildren().addAll(image, naam, huur, kostprijs);
    }

}
