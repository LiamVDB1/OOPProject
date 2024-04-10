package be.ugent.objprog.ugentopoly.tileMidCards;

import be.ugent.objprog.ugentopoly.tiles.Street;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class StreetMidCard extends TileMidCard {
    private Street street;

    public StreetMidCard(Street street){
        //TileCard Klasse zet Width en Height en Anchors.
        super();

        this.street = street;
        initalizeUI();
    }

    public void initalizeUI(){
        Pane colorPane = makeColorPane();

        Label name = makeLabel(street.getText(), 80.0);

        Label kostPrijs = makeLabel("KostPrijs: € " + street.getCost(), 150.0);

        Label huur = makeLabel("Huur: € "+ street.getRent(), 200.0);

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
