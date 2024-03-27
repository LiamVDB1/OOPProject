package be.ugent.objprog.ugentopoly;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class StreetCard extends TileCard{
    private Street street;

    public StreetCard(Street street){
        //TileCard Klasse zet Width en Height en Anchors.
        super();

        this.street = street;
        initalizeUI();
    }

    public void initalizeUI(){

        //De verschillende elementen maken
        Pane colorPane = makeColorPane();

        // Labels maken
        //Label name = everyLabel(street.getId());
        Label name = everyLabel("Test");
        AnchorPane.setTopAnchor(name, 70.0);

        //Label kostPrijs = everyLabel("KostPrijs: € " + street.getKostPrijs());
        Label kostPrijs = everyLabel("KostPrijs: € 100");
        AnchorPane.setTopAnchor(kostPrijs, 140.0);

        //Label huur = everyLabel("Huur: € "+ street.getHuur());
        Label huur = everyLabel("Huur: 10");
        AnchorPane.setTopAnchor(huur, 190.0);

        this.getChildren().addAll(colorPane, name, kostPrijs, huur);
    }

    public Pane makeColorPane(){
        Pane colorPane = new Pane();
        colorPane.setPrefWidth(180);
        colorPane.setPrefHeight(50);

        AnchorPane.setTopAnchor(colorPane, 0.0);
        AnchorPane.setLeftAnchor(colorPane, 0.0);
        AnchorPane.setRightAnchor(colorPane, 0.0);

        //colorPane.setStyle("-fx-background-color: " + street.getColor() + ";");
        colorPane.setStyle("-fx-background-color: " + " #ff0000" + ";");
        return colorPane;
    }
}
