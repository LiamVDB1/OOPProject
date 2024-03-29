package be.ugent.objprog.ugentopoly;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
public class StartCard extends TileCard{
    Start start;

    public StartCard(Start start){
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

        //Label name = everyLabel(start.getId());
        Label name = everyLabel("Start");
        AnchorPane.setTopAnchor(name, 210.0);

        this.getChildren().addAll(image, name);
    }
}
