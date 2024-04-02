package be.ugent.objprog.ugentopoly;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
        ImageView image = null;
        if (utilityNr == '1'){
            image = makeImage("utility1.png");
            AnchorPane.setTopAnchor(image, 60.0);
        } else {
            image = makeImage("utility2.png");
            AnchorPane.setTopAnchor(image, 40.0);
        }

        image.setFitWidth(150);
        AnchorPane.setLeftAnchor(image, 12.5);
        AnchorPane.setRightAnchor(image, 12.5);

        Label name = everyLabel(utility.getText());
        AnchorPane.setTopAnchor(name, 170.0);

        Label cost = everyLabel("Amount: € " + utility.getCost());
        AnchorPane.setTopAnchor(cost, 215.0);

        this.getChildren().addAll(image, name, cost);
    }
}
