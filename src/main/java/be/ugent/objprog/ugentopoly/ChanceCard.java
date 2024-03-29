package be.ugent.objprog.ugentopoly;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ChanceCard extends TileCard{
    Chance chance;
    public ChanceCard(Chance chance){
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

        //Label name = everyLabel(chance.getId());
        Label name = everyLabel("Chance");
        AnchorPane.setTopAnchor(name, 200.0);

        this.getChildren().addAll(image, name);
    }
}
