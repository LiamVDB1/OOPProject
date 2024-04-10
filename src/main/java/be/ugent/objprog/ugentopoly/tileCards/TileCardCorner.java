package be.ugent.objprog.ugentopoly.tileCards;

import be.ugent.objprog.ugentopoly.TileCard;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.Map;

public abstract class TileCardCorner extends TileCard {
    protected GridPane Parent;
    protected int pos;
    protected Map<Integer, Integer> rotCorner;

    //LT is Left of Top. Deze zijn de standaarden.
    public TileCardCorner(GridPane Parent, int gridPos) {
        super();
        this.Parent = Parent; this.pos = gridPos;
        this.setPrefSize(148, 148);
        this.getStyleClass().add("tile");


        if (Parent.getId().equals("top") || Parent.getId().equals("bottom")){ Parent.add(this, gridPos, 0);
        } else { Parent.add(this, 0, gridPos);
        }

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
