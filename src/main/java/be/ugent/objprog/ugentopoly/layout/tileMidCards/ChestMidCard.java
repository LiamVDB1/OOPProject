package be.ugent.objprog.ugentopoly.layout.tileMidCards;

import be.ugent.objprog.ugentopoly.tiles.Chest;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ChestMidCard extends TileMidCard {
    Chest chest;
    public ChestMidCard(Chest chest){
        super();
        this.chest = chest;
        initializeUI();
    }

    public void initializeUI(){
        ImageView image = makeImage("chest.png", 125, 30.0, 25.0, 25.0);

        Label name = makeLabel(chest.getText(), 180.0);

        this.getChildren().addAll(image, name);
    }
}
