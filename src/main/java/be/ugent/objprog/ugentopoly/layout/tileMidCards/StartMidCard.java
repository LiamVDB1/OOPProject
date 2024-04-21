package be.ugent.objprog.ugentopoly.layout.tileMidCards;

import be.ugent.objprog.ugentopoly.tiles.Start;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class StartMidCard extends TileMidCard {
    Start start;

    public StartMidCard(Start start){
        super();
        this.start = start;
        initializeUI();
    }

    public void initializeUI(){
        ImageView image = makeImage(start.getImage(), 125, 20.0, 25.0, 25.0);

        Label name = makeLabel(start.getText(), 210.0);

        this.getChildren().addAll(image, name);
    }
}
