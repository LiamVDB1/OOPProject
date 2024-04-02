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

public abstract class CornerTileCard extends AnchorPane {
    protected GridPane Parent;
    protected int pos;
    protected Map<Integer, Integer> rotCorner;

    //LT is Left of Top. Deze zijn de standaarden.
    public CornerTileCard(GridPane Parent, int pos) {
        super();
        this.Parent = Parent;
        this.pos = pos;
        this.setPrefSize(148, 148);

        rotCorner = Map.of(
                0, 45,
                10, 135,
                20, 225,
                30, 315
        );
    }

    protected Label everyLabel(String text){
        Label label = new Label(text);

        label.setAlignment(javafx.geometry.Pos.CENTER);

        label.setWrapText(true);
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));

        return label;
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
    protected Group MakeName(String text, int width, int height, Double topAnchor, Double leftAnchor, Double rightAnchor, Double bottomAnchor, int rotate){
        Label name = everyLabel(text);
        Group nameGroup = new Group(name);

        name.setPrefSize(width, height);

        name.setRotate(rotate);

        AnchorPane.setTopAnchor(nameGroup, topAnchor);
        AnchorPane.setLeftAnchor(nameGroup, leftAnchor);
        AnchorPane.setRightAnchor(nameGroup, rightAnchor);
        AnchorPane.setBottomAnchor(nameGroup, bottomAnchor);

        return nameGroup;

    }

    protected Group MakeImage(String fileName, int fitHeight, Double topAnchor, Double leftAnchor, Double rightAnchor, Double bottomAnchor, int rotate){
        ImageView image = everyImage(fileName);

        Group imageGroup = new Group(image);

        image.setRotate(rotate);

        image.setFitHeight(fitHeight);

        AnchorPane.setTopAnchor(imageGroup, topAnchor);
        AnchorPane.setLeftAnchor(imageGroup, leftAnchor);
        AnchorPane.setRightAnchor(imageGroup, rightAnchor);
        AnchorPane.setBottomAnchor(imageGroup, bottomAnchor);

        return imageGroup;
    }
}
