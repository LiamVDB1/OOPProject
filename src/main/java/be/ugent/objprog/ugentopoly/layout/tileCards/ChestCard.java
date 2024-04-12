package be.ugent.objprog.ugentopoly.layout.tileCards;

import be.ugent.objprog.ugentopoly.tiles.Chest;
import javafx.scene.Group;

public class ChestCard extends TileCardNormal {
    Chest chest;
    public ChestCard(Chest chest, boolean vertical, boolean LT){
        super(vertical, LT);
        this.chest = chest;
        this.setOnMouseClicked(event -> chest.getBord().showTile(chest));
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("chest.png", 41, 15.0);

        Group name = makeName(chest.getText(), 78, 61, 0.0, 70.0);

        this.getChildren().addAll(image, name);
    }
}
