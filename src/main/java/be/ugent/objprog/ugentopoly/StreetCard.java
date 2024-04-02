package be.ugent.objprog.ugentopoly;

import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class StreetCard extends TileCard{
    private Street street;
    public StreetCard(Street street, GridPane parent, int pos, boolean vertical, boolean LT){
        super(parent, pos, vertical, LT);
        this.street = street;
        initializeUI();
    }
    public void initializeUI(){
        Pane colorPane = makeColorPane();

        //Group name = makeName(street.getText(), 123, 61, 25.0, vertical);
        Group name = MakeName("BLABLABALBALBAALBAL", 123, 61, 25.0, 0.0);

        this.getChildren().addAll(colorPane, name);
    }

    public Pane makeColorPane(){
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


        //colorPane.setStyle("-fx-background-color: " + street.getColor() + ";");
        colorPane.setStyle("-fx-background-color: " + "#9932cc" +  ";");
        return colorPane;
    }
}
