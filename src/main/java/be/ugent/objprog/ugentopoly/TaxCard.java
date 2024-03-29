package be.ugent.objprog.ugentopoly;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class TaxCard extends TileCard{
    Tax tax;
    public TaxCard(Tax tax){
        super();
        this.tax = tax;
        initializeUI();
    }

    public void initializeUI(){
        ImageView image = makeImage("tax.png");

        image.setFitWidth(125);
        AnchorPane.setTopAnchor(image, 30.0);
        AnchorPane.setLeftAnchor(image, 25.0);
        AnchorPane.setRightAnchor(image, 25.0);

        //Label name = everyLabel(tax.getId());
        Label name = everyLabel("Tax");
        AnchorPane.setTopAnchor(name, 190.0);

        this.getChildren().addAll(image, name);
    }
}
