package be.ugent.objprog.ugentopoly.layout.tileCards;

import be.ugent.objprog.ugentopoly.tiles.Utility;
import javafx.scene.Group;

public class UtilityCard extends TileCardNormal {
    Utility utility;
    public UtilityCard(Utility utility, boolean vertical, boolean LT){
        super(vertical, LT);
        this.utility = utility;
        this.setOnMouseClicked(event -> utility.getBoardModel().getController().showTile(utility));
        initializeUI();
    }

    public void initializeUI(){
        Group image;
        if (utility.getNr() == 1) { image = makeImage(utility.getImage(), 33, 5.7);
        } else { image = makeImage(utility.getImage(), 51, 20.5);
        }

        this.getChildren().addAll(image);
    }
}
