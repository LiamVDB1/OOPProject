package be.ugent.objprog.ugentopoly;

import javafx.scene.layout.GridPane;
import javafx.scene.Group;

public class FreeParkingCard extends CornerTileCard{
    FreeParking freeParking;
    int rot;
    public FreeParkingCard(FreeParking freeParking, GridPane parent, int gridPos){
        super(parent, gridPos);
        this.freeParking = freeParking;
        //this.pos = freeParking.getPos();
        this.pos = 20;
        this.rot = rotCorner.get(pos);
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("free_parking.png", 80,45);

        Group name = MakeName("Academisch kwartiertje", 90, 45);

        this.setRotate(rot);

        this.getChildren().addAll(image, name);
    }
}
