package be.ugent.objprog.ugentopoly;

import javafx.scene.layout.GridPane;
import javafx.scene.Group;

public class FreeParkingCard extends TileCardCorner {
    FreeParking freeParking;
    int rot;
    public FreeParkingCard(FreeParking freeParking, GridPane parent, int gridPos){
        super(parent, gridPos);
        this.freeParking = freeParking;
        this.pos = freeParking.getPosition();
        this.rot = rotCorner.get(pos);
        this.setOnMouseClicked(event -> this.freeParking.getBord().showTile(freeParking));
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("free_parking.png", 80,45);

        Group name = MakeName(freeParking.getText(), 90, 45);

        this.setRotate(rot);

        this.getChildren().addAll(image, name);
    }
}
