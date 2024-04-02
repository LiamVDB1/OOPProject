package be.ugent.objprog.ugentopoly;

import javafx.scene.layout.GridPane;
import javafx.scene.Group;

public class UtilityCard extends TileCard{
    Utility utility;
    int nr;
    public UtilityCard(Utility utility, GridPane parent, int pos, boolean vertical, boolean LT){
        super(parent, pos, vertical, LT);
        this.utility = utility;
        this.nr = utility.getNr();
        initializeUI();
    }

    public void initializeUI(){
        Group image = null;
        if (nr == 1) {
            image = MakeImage("utility1.png", 33, 5.7);
        } else {
            image = MakeImage("utility2.png", 51, 20.5);
        }

        this.getChildren().addAll(image);
    }
}
