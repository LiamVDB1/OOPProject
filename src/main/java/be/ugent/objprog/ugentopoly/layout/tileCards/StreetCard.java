package be.ugent.objprog.ugentopoly.layout.tileCards;

import be.ugent.objprog.ugentopoly.tiles.Street;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class StreetCard extends TileCardNormal {
    private Street street;
    public StreetCard(Street street, boolean vertical, boolean LT){
        super(vertical, LT);
        this.street = street;
        this.setOnMouseClicked(event -> street.getBoardModel().getController().showTile(street));
        initializeUI();
    }
    public void initializeUI(){
        Rectangle colorPane = makeColorPane();

        String text = street.getText();

        Group name = makeName(street.getText(), 123, 61, 25.0, 0.0);

        this.getChildren().addAll(colorPane, name);
    }

    /*public Pane makeColorPane(){
        Pane colorPane = new Pane();
        if (vertical) {
            colorPane.setPrefSize(25, 61);
            AnchorPane.setLeftAnchor(colorPane, 123.0);
            AnchorPane.setTopAnchor(colorPane, 0.5);
            AnchorPane.setRightAnchor(colorPane, 0.5);
            AnchorPane.setBottomAnchor(colorPane, 0.5);
        } else {
            colorPane.setPrefSize(60, 25);
            AnchorPane.setLeftAnchor(colorPane, 0.5);
            AnchorPane.setTopAnchor(colorPane, 123.0);
            AnchorPane.setRightAnchor(colorPane, 0.5);
            AnchorPane.setBottomAnchor(colorPane, 0.5);
        }


        colorPane.setStyle("-fx-background-color: " + street.getColor() + ";");
        return colorPane;
    }*/
    public Rectangle makeColorPane(){
        Rectangle colorRectangle = street.rectangleCreator(null, null);
        if (vertical) {
            colorRectangle.setWidth(24.5);
            colorRectangle.setHeight(60);
            AnchorPane.setLeftAnchor(colorRectangle, 123.0);
            AnchorPane.setTopAnchor(colorRectangle, 0.5);
        } else {
            colorRectangle.setWidth(60);
            colorRectangle.setHeight(24.5);
            AnchorPane.setLeftAnchor(colorRectangle, 0.5);
            AnchorPane.setTopAnchor(colorRectangle, 123.0);
        }
        AnchorPane.setRightAnchor(colorRectangle, 0.5);
        AnchorPane.setBottomAnchor(colorRectangle, 0.5);

        return colorRectangle;
    }
}
