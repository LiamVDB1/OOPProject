package be.ugent.objprog.ugentopoly;

import javafx.scene.layout.GridPane;
import javafx.scene.Group;

public class FreeParkingCard extends CornerTileCard{
    FreeParking freeParking;
    public FreeParkingCard(FreeParking freeParking, GridPane parent, int pos){
        super(parent, pos);
        this.freeParking = freeParking;
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("free_parking.png", , 30.0);

        Group name = MakeName("Free Parking", 125, 190, 0.0, 30.0);

        this.getChildren().addAll(image, name);
    }
}
