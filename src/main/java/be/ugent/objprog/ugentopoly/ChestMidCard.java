package be.ugent.objprog.ugentopoly;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ChestMidCard extends TileMidCard {
    Chest chest;
    public ChestMidCard(Chest chest){
        super();
        this.chest = chest;
        initializeUI();
    }

    public void initializeUI(){
        ImageView image = makeImage("chest.png");

        image.setFitWidth(125);
        AnchorPane.setTopAnchor(image, 30.0);
        AnchorPane.setLeftAnchor(image, 25.0);
        AnchorPane.setRightAnchor(image, 25.0);

        Label name = everyLabel(chest.getText());
        AnchorPane.setTopAnchor(name, 180.0);

        this.getChildren().addAll(image, name);
    }
}
