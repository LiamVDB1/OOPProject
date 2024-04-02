package be.ugent.objprog.ugentopoly;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;

public class ChanceCard extends TileCard{
    Chance chance;

    public ChanceCard(Chance chance, GridPane parent, int pos, boolean vertical, boolean LT){
        super(parent, pos, vertical, LT);
        this.chance = chance;
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("chance.png", 46, 30.0);

        Group name = MakeName("Kans", 118, 61, 0.0, 30.0);

        this.getChildren().addAll(image, name);
    }
}
