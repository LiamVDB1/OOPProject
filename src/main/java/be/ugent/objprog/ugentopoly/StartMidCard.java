package be.ugent.objprog.ugentopoly;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
public class StartMidCard extends TileMidCard {
    Start start;

    public StartMidCard(Start start){
        super();
        this.start = start;
        initializeUI();
    }

    public void initializeUI(){
        ImageView image = makeImage("start.png");

        image.setFitWidth(125);
        AnchorPane.setTopAnchor(image, 20.0);
        AnchorPane.setLeftAnchor(image, 25.0);
        AnchorPane.setRightAnchor(image, 25.0);

        Label name = everyLabel(start.getText());
        AnchorPane.setTopAnchor(name, 210.0);

        this.getChildren().addAll(image, name);
    }
}
