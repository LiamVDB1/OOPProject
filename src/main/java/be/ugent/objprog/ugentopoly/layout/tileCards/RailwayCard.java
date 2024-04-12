package be.ugent.objprog.ugentopoly.layout.tileCards;

import be.ugent.objprog.ugentopoly.tiles.Railway;
import javafx.scene.Group;

public class RailwayCard extends TileCardNormal {
    Railway railway;
    public RailwayCard(Railway railway, boolean vertical, boolean LT){
        super(vertical, LT);
        this.railway = railway;
        this.setOnMouseClicked(event -> railway.getBord().showTile(railway));
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("railway.png", 46, 15.0);

        Group name = makeName(railway.getText(), 83, 61, 0.0, 65.0);

        this.getChildren().addAll(image, name);
    }
}
