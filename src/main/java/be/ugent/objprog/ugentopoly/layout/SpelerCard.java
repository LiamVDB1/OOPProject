package be.ugent.objprog.ugentopoly.layout;

import javafx.scene.layout.AnchorPane;

public class SpelerCard extends AnchorPane{

    public SpelerCard(){
        super();
        AnchorPane.setTopAnchor(this, 0.0); AnchorPane.setLeftAnchor(this, 0.0); AnchorPane.setRightAnchor(this, 0.0); AnchorPane.setBottomAnchor(this, 0.0);
        this.setPrefSize(175, 275);
    }
}
