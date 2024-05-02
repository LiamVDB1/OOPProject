package be.ugent.objprog.ugentopoly.fxmlControllers;

import be.ugent.objprog.ugentopoly.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class StartGameController {

    private StartGameModel model;

    @FXML private GridPane grid;
    @FXML private Label errorMessage;

    public void setModel(BoardModel boardModel) {
        this.model = new StartGameModel(boardModel, grid, errorMessage);
    }

    @FXML
    public void spelerToevoegen(){
        model.spelerToevoegen();
    }

    @FXML
    public void startSpel(){
        model.startSpel();
        Stage stage = (Stage) errorMessage.getScene().getWindow();
        stage.close();
    }

}
