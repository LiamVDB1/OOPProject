package be.ugent.objprog.ugentopoly.layout.tileCards;

import be.ugent.objprog.ugentopoly.Card;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class TileCardNormal extends Card implements TileCards {
    protected boolean vertical;
    protected boolean LT;


    //LT is Left of Top. Deze zijn de standaarden.
    public TileCardNormal(boolean vertical, boolean LT) {
        super();
        this.vertical = vertical; this.LT = LT;
        this.getStyleClass().add("tile");

        initialize();
    }
    private void initialize(){
        if (vertical){
            this.setPrefSize(148, 61);
        } else {
            this.setPrefSize(61, 148);
        }

        if (! LT){ this.setRotate(180); }


    }

    public boolean getVertical(){
        return vertical;
    }

    protected Label everyLabel(String text){
        Label label = super.everyLabel(text);
        label.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
        return label;
    }

    //RBAnchor is de Right of Bottom anchor, afhangend van vertical.
    //LTAnchor is de Left of Top anchor, afhangend van vertical.
    protected Group makeName(String text, int width, int height, Double RBAnchor, Double LTAnchor){
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
    protected Group makeImage(Image image, int fitHeight, Double LTAnchor){
        ImageView imageView = everyImage(image);

        Group imageGroup = new Group(imageView);

        double otherAnchor = (61 - fitHeight)/2;


        imageView.setFitHeight(fitHeight);
        if (vertical){
            AnchorPane.setTopAnchor(imageGroup, otherAnchor);
            AnchorPane.setLeftAnchor(imageGroup, LTAnchor);
            AnchorPane.setBottomAnchor(imageGroup, otherAnchor);
        } else {
            imageView.setRotate(90);
            AnchorPane.setTopAnchor(imageGroup, LTAnchor);
            AnchorPane.setLeftAnchor(imageGroup, otherAnchor);
            AnchorPane.setRightAnchor(imageGroup, otherAnchor);
        }

        return imageGroup;
    }

    @Override
    public void setPion(ImageView imageView, double spelerAnchor){
        Group imageGroup = new Group(imageView);
        if (vertical){
            imageView.setRotate(0);
            AnchorPane.setTopAnchor(imageGroup, 5.0);
            AnchorPane.setLeftAnchor(imageGroup, spelerAnchor);
        } else {
            imageView.setRotate(90);
            AnchorPane.setTopAnchor(imageGroup, spelerAnchor);
            AnchorPane.setLeftAnchor(imageGroup, 5.0);
        }
        this.getChildren().add(imageGroup);
    }

    @Override
    public void removePion(ImageView image){
        this.getChildren().remove(image);
    }
}
