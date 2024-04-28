package be.ugent.objprog.ugentopoly.layout;

import be.ugent.objprog.dice.DicePanel;
import be.ugent.objprog.ugentopoly.fxmlControllers.UgentopolyController;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class DiceLayout extends Group{
    private static final DicePanel dicePanel = new DicePanel();

    public DiceLayout(UgentopolyController controller) {
        initialize();
        this.setOnMouseClicked(event -> {
            this.setDisable(true);
            dicePanel.roll(list -> {
                controller.moveSpeler(list);
                this.setDisable(false);
            });
        });
    }
    public void initialize(){
        dicePanel.setRotate(35);
        this.getChildren().add(dicePanel);
    }
}