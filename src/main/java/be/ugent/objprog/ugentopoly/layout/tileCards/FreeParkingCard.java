package be.ugent.objprog.ugentopoly.layout.tileCards;

import be.ugent.objprog.ugentopoly.tiles.FreeParking;
import javafx.scene.layout.GridPane;
import javafx.scene.Group;

public class FreeParkingCard extends TileCardCorner {
    FreeParking freeParking;
    int rot;
    public FreeParkingCard(FreeParking freeParking){
        super();
        this.freeParking = freeParking;
        this.rot = rotCorner.get(freeParking.getPosition());
        this.setOnMouseClicked(event -> freeParking.getBord().showTile(freeParking));
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("free_parking.png", 80,45);

        Group name = MakeName(freeParking.getText(), 90, 45);

        this.setRotate(rot);

        this.getChildren().addAll(image, name);
    }
}
