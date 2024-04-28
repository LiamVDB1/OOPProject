package be.ugent.objprog.ugentopoly.layout;

import be.ugent.objprog.ugentopoly.Card;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class LogLayout extends Card {
    TextArea textArea;
    public LogLayout () {
        this.getStyleClass().add("infoTabPane");
        initialize();
    }
    public void initialize() {
        Label logText = labelWAnchors("Log", 5.0, 5.0, 5.0, null);
        logText.setPrefWidth(266);

        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setPrefSize(266, 266);
        AnchorPane.setTopAnchor(textArea, 25.0);
        AnchorPane.setLeftAnchor(textArea, 5.0);
        AnchorPane.setRightAnchor(textArea, 5.0);
        AnchorPane.setBottomAnchor(textArea, 5.0);

        this.getChildren().addAll(logText, textArea);
    }

    public void updateLog(String log) {
        textArea.appendText(log + "\n");
    }
}
