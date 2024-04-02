package be.ugent.objprog.ugentopoly;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class JailMidCard extends TileMidCard {
    private Jail jail;
    public JailMidCard(Jail jail){
        super();
        this.jail = jail;
        initializeUI();
    }

    public void initializeUI(){
        ImageView image = makeImage("jail.png");

        image.setFitWidth(125);
        AnchorPane.setTopAnchor(image, 30.0);
        AnchorPane.setLeftAnchor(image, 30.0);
        AnchorPane.setRightAnchor(image, 20.0);

        Label naam = everyLabel(jail.getText());
        AnchorPane.setTopAnchor(naam, 220.0);

        this.getChildren().addAll(image, naam);
    }
}
