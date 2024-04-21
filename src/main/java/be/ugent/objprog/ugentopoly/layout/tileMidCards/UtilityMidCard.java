package be.ugent.objprog.ugentopoly.layout.tileMidCards;

import be.ugent.objprog.ugentopoly.tiles.Utility;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class UtilityMidCard extends TileMidCard {
    Utility utility;
    char utilityNr;
    public UtilityMidCard(Utility utility){
        super();
        this.utility = utility;
        this.utilityNr = utility.getId().charAt(utility.getId().length() - 1);
        initializeUI();
    }

    public void initializeUI(){
        ImageView image;
        if (utilityNr == '1'){ image = makeImage(utility.getImage(), 150, 60.0, 12.5, 12.5);
        } else { image = makeImage(utility.getImage(), 150, 40.0, 12.5, 12.5); }

        Label name = makeLabel(utility.getText(), 170.0);

        Label cost = makeLabel("Kostprijs: € " + utility.getCost(), 215.0);

        this.getChildren().addAll(image, name, cost);
    }
}
