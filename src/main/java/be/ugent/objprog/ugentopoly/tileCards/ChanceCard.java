package be.ugent.objprog.ugentopoly.tileCards;

import be.ugent.objprog.ugentopoly.tiles.Chance;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;

public class ChanceCard extends TileCardNormal {
    Chance chance;

    public ChanceCard(Chance chance, GridPane parent, int gridPos, boolean vertical, boolean LT){
        super(parent, gridPos, vertical, LT);
        this.chance = chance;
        this.setOnMouseClicked(event -> chance.getBord().showTile(chance));
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("chance.png", 46, 30.0);

        Group name = MakeName(chance.getText(), 118, 61, 0.0, 30.0);

        this.getChildren().addAll(image, name);
    }
}
