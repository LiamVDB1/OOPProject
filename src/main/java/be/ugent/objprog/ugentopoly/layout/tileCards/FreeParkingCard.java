package be.ugent.objprog.ugentopoly.layout.tileCards;

import be.ugent.objprog.ugentopoly.tiles.FreeParking;
import javafx.scene.Group;

public class FreeParkingCard extends TileCardCorner {
    FreeParking freeParking;
    int rot;
    public FreeParkingCard(FreeParking freeParking){
        super();
        this.freeParking = freeParking;
        this.rot = rotCorner.get(freeParking.getPosition());
        this.setOnMouseClicked(event -> freeParking.getBord().getController().showTile(freeParking));
        initializeUI();
    }

    public void initializeUI(){
        Group image = makeImage(freeParking.getImage(), 80,45);

        Group name = makeName(freeParking.getText(), 90, 45);

        this.setRotate(rot);

        this.getChildren().addAll(image, name);
    }
}
