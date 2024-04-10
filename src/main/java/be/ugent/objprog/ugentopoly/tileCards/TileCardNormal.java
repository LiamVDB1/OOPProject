package be.ugent.objprog.ugentopoly.tileCards;

import be.ugent.objprog.ugentopoly.TileCard;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public abstract class TileCardNormal extends TileCard {
    protected GridPane Parent;
    protected int pos;
    protected boolean vertical;
    protected boolean LT;


    //LT is Left of Top. Deze zijn de standaarden.
    public TileCardNormal(GridPane Parent, int gridPos, boolean vertical, boolean LT) {
        super();
        this.Parent = Parent; this.pos = gridPos; this.vertical = vertical; this.LT = LT;
        this.getStyleClass().add("tile");

        initialize();
    }
    private void initialize(){
        if (vertical){
            this.setPrefSize(148, 61);
            Parent.add(this, 0, pos);
        } else {
            this.setPrefSize(61, 148);
            Parent.add(this, pos, 0);
        }

        if (! LT){ this.setRotate(180); }
    }

    protected Label everyLabel(String text){
        Label label = super.everyLabel(text);
        label.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
        return label;
    }

    //RBAnchor is de Right of Bottom anchor, afhangend van vertical.
    //LTAnchor is de Left of Top anchor, afhangend van vertical.
    protected Group MakeName(String text, int width, int height, Double RBAnchor, Double LTAnchor){
        Label name = everyLabel(text);
        Group nameGroup = new Group(name);

        name.setPrefSize(width, height);

        if (vertical){
            AnchorPane.setRightAnchor(nameGroup, RBAnchor);
            AnchorPane.setBottomAnchor(nameGroup, 0.0);
            AnchorPane.setTopAnchor(nameGroup, 0.0);
            AnchorPane.setLeftAnchor(nameGroup, LTAnchor);

        } else {
            name.setRotate(90);
            AnchorPane.setRightAnchor(nameGroup, 0.0);
            AnchorPane.setBottomAnchor(nameGroup, RBAnchor);
            AnchorPane.setTopAnchor(nameGroup, LTAnchor);
            AnchorPane.setLeftAnchor(nameGroup, 0.0);
        }

        return nameGroup;

    }

    //Double in plaats van double om null te kunnen gebruiken.
    protected Group MakeImage(String fileName, int fitHeight, Double LTAnchor){
        ImageView image = everyImage(fileName);

        Group imageGroup = new Group(image);

        double otherAnchor = (61 - fitHeight)/2;


        image.setFitHeight(fitHeight);
        if (vertical){
            AnchorPane.setTopAnchor(imageGroup, otherAnchor);
            AnchorPane.setLeftAnchor(imageGroup, LTAnchor);
            AnchorPane.setBottomAnchor(imageGroup, otherAnchor);
        } else {
            image.setRotate(90);
            AnchorPane.setTopAnchor(imageGroup, LTAnchor);
            AnchorPane.setLeftAnchor(imageGroup, otherAnchor);
            AnchorPane.setRightAnchor(imageGroup, otherAnchor);
        }

        return imageGroup;
    }
}
