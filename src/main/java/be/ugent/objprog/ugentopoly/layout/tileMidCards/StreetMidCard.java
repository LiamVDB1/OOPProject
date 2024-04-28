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

        Label kostPrijs = makeLabel("KostPrijs: € " + street.getCost(), 150.0);

        Label huur = makeLabel("Huur: € "+ street.getRent(), 200.0);

        this.getChildren().addAll(colorRectangle, name, kostPrijs, huur);
    }

    public Rectangle makeColorRectangle(){
        Rectangle colorRectangle = street.rectangleCreator();
        colorRectangle.setWidth(175);
        colorRectangle.setHeight(50);

        AnchorPane.setTopAnchor(colorRectangle, 0.0);
        AnchorPane.setLeftAnchor(colorRectangle, 0.0);
        AnchorPane.setRightAnchor(colorRectangle, 0.0);

        return colorRectangle;
    }
}
