package be.ugent.objprog.ugentopoly.tileMidCards;

import be.ugent.objprog.ugentopoly.tiles.Tax;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class TaxMidCard extends TileMidCard {
    Tax tax;
    public TaxMidCard(Tax tax){
        super();
        this.tax = tax;
        initializeUI();
    }

    public void initializeUI(){
        ImageView image = makeImage("tax.png", 125, 30.0, 25.0, 25.0);

        Label name = makeLabel(tax.getText(), 175.0);

        Label cost = makeLabel("Amount: € " + tax.getAmount(), 225.0);

        this.getChildren().addAll(image, name, cost);
    }
}
