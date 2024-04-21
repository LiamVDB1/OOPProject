package be.ugent.objprog.ugentopoly.layout.tileCards;

import be.ugent.objprog.ugentopoly.tiles.Start;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class StartCard extends TileCardCorner {
    Start start;
    int rot;
    public StartCard(Start start){
        super();
        this.start = start;
        this.rot = rotCorner.get(start.getPosition());
        this.setOnMouseClicked(event -> start.getBord().getController().showTile(start));
        initializeUI();
    }

    public void initializeUI(){
        Group image = makeStartImage();

        Group arrow = makeStartArrowImage();

        this.setRotate(rot);

        this.getChildren().addAll(image, arrow);
    }

    private Group makeStartImage(){
        ImageView image = everyImage(start.getImage());

        Group imageGroup = new Group(image);

        image.setFitHeight(138);

        AnchorPane.setTopAnchor(imageGroup, 5.0);
        AnchorPane.setRightAnchor(imageGroup, 10.0);
        AnchorPane.setBottomAnchor(imageGroup, 5.0);

        return imageGroup;
    }

    private Group makeStartArrowImage(){
        ImageView image = everyImage(start.getStartArrow());

        Group imageGroup = new Group(image);

        image.setFitWidth(128);

        image.setRotate(90);

        AnchorPane.setTopAnchor(imageGroup, 10.0);
        AnchorPane.setLeftAnchor(imageGroup, 20.0);
        AnchorPane.setBottomAnchor(imageGroup, 10.0);

        return imageGroup;
    }
}
