package be.ugent.objprog.ugentopoly.layout.tileCards;

import be.ugent.objprog.ugentopoly.tiles.Tax;
import javafx.scene.Group;

public class TaxCard extends TileCardNormal {
    Tax tax;
    public TaxCard(Tax tax, boolean vertical, boolean LT){
        super(vertical, LT);
        this.tax = tax;
        this.setOnMouseClicked(event -> tax.getBord().showTile(tax));
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("tax.png", 46, 15.0);

        Group name = makeName(tax.getText(), 88, 61, 0.0, 60.0);

        this.getChildren().addAll(image, name);
    }
}
