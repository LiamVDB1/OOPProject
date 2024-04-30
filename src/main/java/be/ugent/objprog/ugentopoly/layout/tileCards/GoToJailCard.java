package be.ugent.objprog.ugentopoly.layout.tileCards;

import be.ugent.objprog.ugentopoly.tiles.GoToJail;
import javafx.scene.Group;

public class GoToJailCard extends TileCardCorner {
    GoToJail goToJail;
    int rot;
    public GoToJailCard(GoToJail goToJail){
        super();
        this.goToJail = goToJail;
        this.rot = rotCorner.get(goToJail.getPosition());
        this.setOnMouseClicked(event -> goToJail.getBoardModel().getController().showTile(goToJail));
        initializeUI();
    }

    public void initializeUI(){
        Group image = makeImage(goToJail.getImage(), 85,45);

        Group name = makeName(goToJail.getText(), 100, 45);

        this.setRotate(rot);

        this.getChildren().addAll(image, name);
    }
}
