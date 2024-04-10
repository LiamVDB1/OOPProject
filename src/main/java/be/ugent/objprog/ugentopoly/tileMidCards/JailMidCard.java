package be.ugent.objprog.ugentopoly.tileMidCards;

import be.ugent.objprog.ugentopoly.tiles.Jail;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class JailMidCard extends TileMidCard {
    private Jail jail;
    public JailMidCard(Jail jail){
        super();
        this.jail = jail;
        initializeUI();
    }

    public void initializeUI(){
        ImageView image = makeImage("jail.png", 125, 30.0, 30.0, 20.0);

        Label naam = makeLabel(jail.getText(), 220.0);

        this.getChildren().addAll(image, naam);
    }
}
