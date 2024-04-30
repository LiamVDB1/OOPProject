package be.ugent.objprog.ugentopoly.layout;

import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.fxmlControllers.UgentopolyController;
import be.ugent.objprog.ugentopoly.tiles.Eigendom;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.Group;

public class BuyOrSkipLayout extends Card{
    private UgentopolyController controller;
    private Button buyButton;
    private Button skipButton;
    public BuyOrSkipLayout(UgentopolyController controller){
        this.controller = controller;
        initialize();
    }
    public void initialize(){
        buyButton = new Button("Koop Eigendom");
        buyButton.setId("buyButton");
        buyButton.setPrefWidth(175);
        buyButton.setRotate(90);
        Node buyButtonGroup = nodeWAnchors(new Group(buyButton), 62.5, 377.5, null, 62.5);

        skipButton = new Button("Skip Eigendom");
        skipButton.setId("skipButton");
        skipButton.setPrefWidth(175);
        skipButton.setRotate(270);
        skipButton.setTextFill(javafx.scene.paint.Color.WHITE);
        skipButton.setOnAction(e -> controller.skipEigendom());
        Node skipButtonGroup = nodeWAnchors(new Group(skipButton), 62.5, null, 377.5, 62.5);

        this.getChildren().addAll(buyButtonGroup, skipButtonGroup);
    }

    public void setTile(Eigendom eigendom){
        buyButton.setOnAction(e -> {
            controller.buyEigendom(eigendom);
        });
    }
}
