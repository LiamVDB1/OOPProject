package be.ugent.objprog.ugentopoly;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class StartCard extends CornerTileCard{
    Start start;
    int rot;
    public StartCard(Start start, GridPane parent, int gridPos){
        super(parent, gridPos);
        this.start = start;
        //this.pos = start.getPos();
        this.pos = 0;
        this.rot = rotCorner.get(pos);
        initializeUI();
    }

    public void initializeUI(){
        Group image = makeStartImage();

        Group arrow = makeStartArrowImage();

        this.setRotate(rot);

        this.getChildren().addAll(image, arrow);
    }

    private Group makeStartImage(){
        ImageView image = everyImage("start.png");

        Group imageGroup = new Group(image);

        image.setFitHeight(138);

        AnchorPane.setTopAnchor(imageGroup, 5.0);
        AnchorPane.setRightAnchor(imageGroup, 10.0);
        AnchorPane.setBottomAnchor(imageGroup, 5.0);

        return imageGroup;
    }

    private Group makeStartArrowImage(){
        ImageView image = everyImage("start-arrow.png");

        Group imageGroup = new Group(image);

        image.setFitWidth(128);

        image.setRotate(90);

        AnchorPane.setTopAnchor(imageGroup, 10.0);
        AnchorPane.setLeftAnchor(imageGroup, 20.0);
        AnchorPane.setBottomAnchor(imageGroup, 10.0);

        return imageGroup;
    }
}
