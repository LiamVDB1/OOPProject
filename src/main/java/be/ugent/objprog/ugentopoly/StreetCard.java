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
        Label name = everyLabel(street.getText());
        AnchorPane.setTopAnchor(name, 80.0);

        Label kostPrijs = everyLabel("KostPrijs: € " + street.getCost());
        AnchorPane.setTopAnchor(kostPrijs, 150.0);

        Label huur = everyLabel("Huur: € "+ street.getRent());
        AnchorPane.setTopAnchor(huur, 200.0);

        this.getChildren().addAll(colorPane, name, kostPrijs, huur);
    }

    public Pane makeColorPane(){
        Pane colorPane = new Pane();
        colorPane.setPrefWidth(180);
        colorPane.setPrefHeight(50);

        AnchorPane.setTopAnchor(colorPane, 0.0);
        AnchorPane.setLeftAnchor(colorPane, 0.0);
        AnchorPane.setRightAnchor(colorPane, 0.0);

        colorPane.setStyle("-fx-background-color: " + street.getColor() + ";");
        return colorPane;
    }
}
