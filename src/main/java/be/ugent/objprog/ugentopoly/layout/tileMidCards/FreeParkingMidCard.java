package be.ugent.objprog.ugentopoly.layout.tileMidCards;

import be.ugent.objprog.ugentopoly.tiles.FreeParking;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class FreeParkingMidCard extends TileMidCard {
    FreeParking freeParking;

    public FreeParkingMidCard(FreeParking freeParking){
        super();
        this.freeParking = freeParking;
        initializeUI();
    }

    public void initializeUI(){
        ImageView image = makeImage("free_parking.png", 125, 30.0, 25.0, 25.0);

        Label name = makeLabel(freeParking.getText(), 190.0);

        this.getChildren().addAll(image, name);
    }
}
