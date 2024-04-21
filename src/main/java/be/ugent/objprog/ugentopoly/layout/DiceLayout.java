package be.ugent.objprog.ugentopoly.layout;

import be.ugent.objprog.dice.DicePanel;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class DiceLayout extends Group{
    private static final DicePanel dicePanel = new DicePanel();

    public DiceLayout() {
        initialize();
        this.setOnMouseClicked(event -> dicePanel.roll(null));
    }
    public void initialize(){
        dicePanel.setRotate(35);
        this.getChildren().add(dicePanel);
    }
}