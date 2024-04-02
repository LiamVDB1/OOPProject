package be.ugent.objprog.ugentopoly;

import javafx.scene.layout.GridPane;
import javafx.scene.Group;

public class RailwayCard extends TileCard{
    Railway railway;
    public RailwayCard(Railway railway, GridPane parent, int pos, boolean vertical, boolean LT){
        super(parent, pos, vertical, LT);
        this.railway = railway;
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("railway.png", 46, 15.0);

        Group name = MakeName("Resto de Brug", 83, 61, 0.0, 65.0);

        this.getChildren().addAll(image, name);
    }
}
