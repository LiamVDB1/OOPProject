package be.ugent.objprog.ugentopoly;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;

public class GoToJailMidCard extends TileMidCard {
    GoToJail goToJail;
    public GoToJailMidCard(GoToJail goToJail){
        super();
        this.goToJail = goToJail;
        initializeUI();
    }

    public void initializeUI(){
        ImageView image = makeImage("go_to_jail.png");

        image.setFitWidth(100);
        AnchorPane.setTopAnchor(image, 30.0);
        AnchorPane.setLeftAnchor(image, 30.0);
        AnchorPane.setRightAnchor(image, 45.0);

        Label naam = everyLabel(goToJail.getText());
        AnchorPane.setTopAnchor(naam, 200.0);

        this.getChildren().addAll(image, naam);
    }
}
