package be.ugent.objprog.ugentopoly;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ChanceMidCard extends TileMidCard {
    Chance chance;
    public ChanceMidCard(Chance chance){
        super();
        this.chance = chance;
        initializeUI();
    }

    public void initializeUI(){
        ImageView image = makeImage("chance.png");

        image.setFitWidth(75);
        AnchorPane.setTopAnchor(image, 30.0);
        AnchorPane.setLeftAnchor(image, 50.0);
        AnchorPane.setRightAnchor(image, 50.0);

        Label name = everyLabel(chance.getText());
        AnchorPane.setTopAnchor(name, 200.0);

        this.getChildren().addAll(image, name);
    }
}
