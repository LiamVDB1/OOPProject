package be.ugent.objprog.ugentopoly;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;

public class JailCard extends CornerTileCard{
    Jail jail;
    int rot;
    public JailCard(Jail jail, GridPane parent, int gridPos){
        super(parent, gridPos);
        this.jail = jail;
        //this.pos = jail.getPos();
        this.pos = 10;
        this.rot = rotCorner.get(pos);
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("jail.png", 90,45);

        Group name = MakeName("De Overpoort", 100, 45);

        this.setRotate(rot);

        this.getChildren().addAll(image, name);
    }
}
