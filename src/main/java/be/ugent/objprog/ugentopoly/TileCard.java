package be.ugent.objprog.ugentopoly;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public abstract class TileCard extends AnchorPane {
    public TileCard(){
        super();
        AnchorPane.setTopAnchor(this, 0.0);
        AnchorPane.setLeftAnchor(this, 0.0);
        AnchorPane.setRightAnchor(this, 0.0);
        AnchorPane.setBottomAnchor(this, 0.0);
        this.setPrefWidth(175);
        this.setPrefHeight(275);
    }

    protected Label everyLabel(String text){
        Label label = new Label(text);

        label.setAlignment(javafx.geometry.Pos.CENTER);
        AnchorPane.setLeftAnchor(label, 0.0);
        AnchorPane.setRightAnchor(label, 0.0);

        label.setWrapText(true);
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        return label;
    }
}
