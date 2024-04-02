package be.ugent.objprog.ugentopoly;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;

public class GoToJailCard extends CornerTileCard{
    GoToJail goToJail;
    int rot;
    public GoToJailCard(GoToJail goToJail, GridPane parent, int gridPos){
        super(parent, gridPos);
        this.goToJail = goToJail;
        //this.pos = goToJail.getPos();
        this.pos = 30;
        this.rot = rotCorner.get(pos);
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("go_to_jail.png", 85,45);

        Group name = MakeName("Ga direct naar De Overpoort", 100, 45);

        this.setRotate(rot);

        this.getChildren().addAll(image, name);
    }
}
