package be.ugent.objprog.ugentopoly.layout.tileCards;

import be.ugent.objprog.ugentopoly.tiles.Jail;
import javafx.scene.Group;

public class JailCard extends TileCardCorner {
    Jail jail;
    int rot;
    public JailCard(Jail jail){
        super();
        this.jail = jail;
        this.rot = rotCorner.get(jail.getPosition());
        this.setOnMouseClicked(event -> jail.getBord().getController().showTile(jail));
        initializeUI();
    }

    public void initializeUI(){
        Group image = makeImage(jail.getImage(), 90,45);

        Group name = makeName(jail.getText(), 100, 45);

        this.setRotate(rot);

        this.getChildren().addAll(image, name);
    }
}
