package be.ugent.objprog.ugentopoly;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;

public class ChestCard extends TileCard{
    Chest chest;
    public ChestCard(Chest chest, GridPane parent, int pos, boolean vertical, boolean LT){
        super(parent, pos, vertical, LT);
        this.chest = chest;
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("chest.png", 41, 15.0);

        Group name = MakeName("Algemeen Fonds", 78, 61, 0.0, 70.0);

        this.getChildren().addAll(image, name);
    }
}
