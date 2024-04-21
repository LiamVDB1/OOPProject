package be.ugent.objprog.ugentopoly.layout.tileMidCards;

import be.ugent.objprog.ugentopoly.Card;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class TileMidCard extends Card {
    public TileMidCard(){
        super();
        AnchorPane.setTopAnchor(this, 0.0); AnchorPane.setLeftAnchor(this, 0.0); AnchorPane.setRightAnchor(this, 0.0); AnchorPane.setBottomAnchor(this, 0.0);
        this.setPrefSize(175, 275);
    }

    protected Label everyLabel(String text){
        Label label = super.everyLabel(text);

        AnchorPane.setLeftAnchor(label, 0.0);
        AnchorPane.setRightAnchor(label, 0.0);

        label.setPadding(new Insets(0.0, 10.0, 0.0, 10.0));

        return label;
    }

    protected Label makeLabel(String text, double tAnchor){
        Label name = everyLabel(text);
        AnchorPane.setTopAnchor(name, tAnchor);
        return name;
    }

    protected ImageView makeImage(Image image, int fitWidth, double tAnchor, double lAnchor, double rAnchor){
        ImageView imageView = everyImage(image);

        imageView.setFitWidth(fitWidth);
        AnchorPane.setTopAnchor(imageView, tAnchor);
        AnchorPane.setLeftAnchor(imageView, lAnchor);
        AnchorPane.setRightAnchor(imageView, rAnchor);

        return imageView;
    }
}
