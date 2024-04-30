package be.ugent.objprog.ugentopoly.layout.tileMidCards;

import be.ugent.objprog.ugentopoly.tiles.Street;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class StreetMidCard extends TileMidCard {
    private Street street;

    public StreetMidCard(Street street){
        //TileCard Klasse zet Width en Height en Anchors.
        super();

        this.street = street;
        initalizeUI();
    }

    public void initalizeUI(){
        Rectangle colorRectangle = makeColorRectangle();

        Label name = makeLabel(street.getText(), 80.0);

        Label kostPrijs = makeLabel("KostPrijs: € " + street.getCost(), 140.0);

        Label huur = makeLabel("BasisHuur: € "+ street.getHuur(), 180.0);

        Label huurDouble = makeLabel("Volledige Straat: \n€ " + street.getHuur() * 2, 220);

        this.getChildren().addAll(colorRectangle, name, kostPrijs, huur, huurDouble);
    }

    public Rectangle makeColorRectangle(){
        Rectangle colorRectangle = street.rectangleCreator(50, 175);

        AnchorPane.setTopAnchor(colorRectangle, 0.0);
        AnchorPane.setLeftAnchor(colorRectangle, 0.0);
        AnchorPane.setRightAnchor(colorRectangle, 0.0);

        return colorRectangle;
    }
}
