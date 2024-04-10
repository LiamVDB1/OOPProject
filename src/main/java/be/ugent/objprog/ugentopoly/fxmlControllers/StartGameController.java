package be.ugent.objprog.ugentopoly.fxmlControllers;

import be.ugent.objprog.ugentopoly.*;
import javafx.fxml.FXML;

public class StartGameController {

    private BoardModel boardModel;

    public void setBoard(BoardModel boardModel) {
        this.boardModel = boardModel;
    }

    @FXML
    public void spelerToevoegen(){
        new SpelerCreator(boardModel);
    }

    @FXML
    public void startSpel(){
        boardModel.startSpel();
    }

}
