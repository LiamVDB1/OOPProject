package be.ugent.objprog.ugentopoly;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class TaxMidCard extends TileMidCard {
    Tax tax;
    public TaxMidCard(Tax tax){
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

        Label name = everyLabel(tax.getText());
        AnchorPane.setTopAnchor(name, 190.0);

        Label cost = everyLabel("Amount: € " + tax.getAmount());
        AnchorPane.setTopAnchor(cost, 225.0);

        this.getChildren().addAll(image, name, cost);
    }
}
