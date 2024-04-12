package be.ugent.objprog.ugentopoly.layout.tileMidCards;

import be.ugent.objprog.ugentopoly.tiles.Chance;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ChanceMidCard extends TileMidCard {
    Chance chance;
    public ChanceMidCard(Chance chance){
        super();
        this.chance = chance;
        initializeUI();
    }

    public void initializeUI(){
        ImageView image = makeImage("chance.png", 75, 30.0, 50.0, 50.0);

        Label name = makeLabel(chance.getText(), 200.0);

        this.getChildren().addAll(image, name);
    }
}
