package be.ugent.objprog.ugentopoly;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;

public class TaxCard extends TileCardNormal {
    Tax tax;
    public TaxCard(Tax tax, GridPane parent, int pos, boolean vertical, boolean LT){
        super(parent, pos, vertical, LT);
        this.tax = tax;
        this.setOnMouseClicked(event -> this.tax.getBord().showTile(tax));
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("tax.png", 46, 15.0);

        Group name = MakeName(tax.getText(), 88, 61, 0.0, 60.0);

        this.getChildren().addAll(image, name);
    }
}
