package be.ugent.objprog.ugentopoly.layout.tileCards;

import be.ugent.objprog.ugentopoly.Card;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.Map;

public abstract class TileCardCorner extends Card {
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

    protected Group MakeName(String text, int width, int rotate){
        Label name = everyLabel(text);
        Group nameGroup = new Group(name);

        name.setPrefWidth(width);

        name.setRotate(rotate);

        AnchorPane.setLeftAnchor(nameGroup, 0.0);
        AnchorPane.setBottomAnchor(nameGroup, 0.0);

        return nameGroup;

    }

    protected Group MakeImage(String fileName, int fitHeight, int rotate){
        ImageView image = everyImage(fileName);

        Group imageGroup = new Group(image);

        image.setRotate(rotate);

        image.setFitHeight(fitHeight);

        AnchorPane.setTopAnchor(imageGroup, 0.0);
        AnchorPane.setRightAnchor(imageGroup, 0.0);

        return imageGroup;
    }
}
