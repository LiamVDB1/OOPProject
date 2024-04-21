package be.ugent.objprog.ugentopoly.layout.tileMidCards;

import be.ugent.objprog.ugentopoly.tiles.GoToJail;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class GoToJailMidCard extends TileMidCard {
    GoToJail goToJail;
    public GoToJailMidCard(GoToJail goToJail){
        super();
        this.goToJail = goToJail;
        initializeUI();
    }

    public void initializeUI(){
        ImageView image = makeImage(goToJail.getImage(), 100, 30.0, 30.0, 45.0);

        Label naam = makeLabel(goToJail.getText(), 200.0);

        this.getChildren().addAll(image, naam);
    }
}
