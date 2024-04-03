package be.ugent.objprog.ugentopoly;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;

public class JailCard extends TileCardCorner {
    Jail jail;
    int rot;
    public JailCard(Jail jail, GridPane parent, int gridPos){
        super(parent, gridPos);
        this.jail = jail;
        this.pos = jail.getPosition();
        this.rot = rotCorner.get(pos);
        this.setOnMouseClicked(event -> this.jail.getBord().showTile(jail));
        initializeUI();
    }

    public void initializeUI(){
        Group image = MakeImage("jail.png", 90,45);

        Group name = MakeName(jail.getText(), 100, 45);

        this.setRotate(rot);

        this.getChildren().addAll(image, name);
    }
}
