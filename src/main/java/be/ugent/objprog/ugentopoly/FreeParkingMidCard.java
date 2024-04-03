package be.ugent.objprog.ugentopoly;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class FreeParkingMidCard extends TileMidCard {
    FreeParking freeParking;

    public FreeParkingMidCard(FreeParking freeParking){
        super();
        this.freeParking = freeParking;
        initializeUI();
    }

    public void initializeUI(){
        ImageView image = makeImage("free_parking.png");

        image.setFitWidth(125);
        AnchorPane.setTopAnchor(image, 30.0);
        AnchorPane.setLeftAnchor(image, 25.0);
        AnchorPane.setRightAnchor(image, 25.0);

        Label name = everyLabel(freeParking.getText());
        AnchorPane.setTopAnchor(name, 190.0);

        this.getChildren().addAll(image, name);
    }
}
