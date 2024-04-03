package be.ugent.objprog.ugentopoly;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;

public class GoToJailCard extends TileCardCorner {
    GoToJail goToJail;
    int rot;
    public GoToJailCard(GoToJail goToJail, GridPane parent, int gridPos){
        super(parent, gridPos);
        this.goToJail = goToJail;
        this.pos = goToJail.getPosition();
        this.rot = rotCorner.get(pos);
        this.setOnMouseClicked(event -> this.goToJail.getBord().showTile(goToJail));
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("go_to_jail.png", 85,45);

        Group name = MakeName(goToJail.getText(), 100, 45);

        this.setRotate(rot);

        this.getChildren().addAll(image, name);
    }
}
