package be.ugent.objprog.ugentopoly;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class UtilityCard extends TileCard{
    Utility utility;
    int utilityNr;
    public UtilityCard(Utility utility){
        super();
        this.utility = utility;
        this.utilityNr = 1;
        initializeUI();
    }

    public void initializeUI(){
        ImageView image = null;
        if (utilityNr == 1){
            image = makeImage("utility1.png");
            AnchorPane.setTopAnchor(image, 30.0);
        } else {
            image = makeImage("utility2.png");
            AnchorPane.setTopAnchor(image, 50.0);
        }

        image.setFitWidth(150);
        AnchorPane.setLeftAnchor(image, 12.5);
        AnchorPane.setRightAnchor(image, 12.5);

        //Label name = everyLabel(utility.getId());
        Label name = everyLabel("Utility");
        AnchorPane.setTopAnchor(name, 180.0);

        this.getChildren().addAll(image, name);
    }
}
