package be.ugent.objprog.ugentopoly;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;

public class ChestCard extends TileCardNormal {
    Chest chest;
    public ChestCard(Chest chest, GridPane parent, int gridPos, boolean vertical, boolean LT){
        super(parent, gridPos, vertical, LT);
        this.chest = chest;
        this.setOnMouseClicked(event -> this.chest.getBord().showTile(chest));
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("chest.png", 41, 15.0);

        Group name = MakeName(chest.getText(), 78, 61, 0.0, 70.0);

        this.getChildren().addAll(image, name);
    }
}
