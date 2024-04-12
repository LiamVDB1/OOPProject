package be.ugent.objprog.ugentopoly.layout.tileCards;

import be.ugent.objprog.ugentopoly.tiles.Chance;
import javafx.scene.Group;

public class ChanceCard extends TileCardNormal {
    Chance chance;

    public ChanceCard(Chance chance, boolean vertical, boolean LT){
        super(vertical, LT);
        this.chance = chance;
        this.setOnMouseClicked(event -> chance.getBord().showTile(chance));
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("chance.png", 46, 30.0);

        Group name = makeName(chance.getText(), 118, 61, 0.0, 30.0);

        this.getChildren().addAll(image, name);
    }
}
