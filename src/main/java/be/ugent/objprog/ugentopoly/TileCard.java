package be.ugent.objprog.ugentopoly;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public abstract class TileCard extends AnchorPane {
    protected GridPane Parent;
    protected int pos;
    protected boolean vertical;
    protected boolean LT;


    //LT is Left of Top. Deze zijn de standaarden.
    public TileCard(GridPane Parent, int pos, boolean vertical, boolean LT) {
        super();
        this.Parent = Parent;
        this.pos = pos;
        this.vertical = vertical;
        this.LT = LT;
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

        if (! LT){
            this.setRotate(180);
        }
    }

    protected Label everyLabel(String text){
        Label label = new Label(text);

        label.setAlignment(javafx.geometry.Pos.CENTER);

        label.setWrapText(true);
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
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

    protected ImageView everyImage(String fileName){
        try (InputStream input = getClass().getResourceAsStream("assets/" + fileName)){
            if (input == null) {throw new NullPointerException();}
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);

            imageView.setPreserveRatio(true);

            return imageView;
        } catch (IOException e) {
            System.err.println("Error railway.png not in assets folder");
        } catch (NullPointerException e){
            System.err.println("Error railway.png not found in asserts folder");
        }
        return null;
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
