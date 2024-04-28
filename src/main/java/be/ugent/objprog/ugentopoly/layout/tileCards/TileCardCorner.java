package be.ugent.objprog.ugentopoly.layout.tileCards;

import be.ugent.objprog.ugentopoly.Card;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.Map;

public abstract class TileCardCorner extends Card implements TileCards {
    protected GridPane Parent;
    protected int gridPos;
    protected Map<Integer, Integer> rotCorner;

    public TileCardCorner() {
        super();
        this.setPrefSize(148, 148);
        this.getStyleClass().add("tile");

        rotCorner = Map.of(
                0, 0,
                10, 90,
                20, 180,
                30, 270
        );
    }

    protected Label everyLabel(String text){
        Label label = super.everyLabel(text);
        label.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
        return label;
    }

    protected Group makeName(String text, int width, int rotate){
        Label name = everyLabel(text);
        Group nameGroup = new Group(name);

        name.setPrefWidth(width);

        name.setRotate(rotate);

        AnchorPane.setLeftAnchor(nameGroup, 0.0);
        AnchorPane.setBottomAnchor(nameGroup, 0.0);

        return nameGroup;

    }

    protected Group makeImage(Image image, int fitHeight, int rotate){
        ImageView imageView = everyImage(image);

        Group imageGroup = new Group(imageView);

        imageView.setRotate(rotate);

        imageView.setFitHeight(fitHeight);

        AnchorPane.setTopAnchor(imageGroup, 0.0);
        AnchorPane.setRightAnchor(imageGroup, 0.0);

        return imageGroup;
    }

    @Override
    public void setPion(ImageView image, double spelerAnchor){
        Group imageGroup = new Group(image);
        image.setRotate(0);
        AnchorPane.setTopAnchor(imageGroup, 30.0);
        AnchorPane.setLeftAnchor(imageGroup, spelerAnchor);
        this.getChildren().add(imageGroup);
    }

    @Override
    public void removePion(ImageView imageView) {
        this.getChildren().remove(imageView);
    }
}
