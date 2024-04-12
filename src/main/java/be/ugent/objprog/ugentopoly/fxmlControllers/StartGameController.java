package be.ugent.objprog.ugentopoly.fxmlControllers;

import be.ugent.objprog.ugentopoly.*;
import javafx.fxml.FXML;

public class StartGameController {

    private Board board;

    public void setBoard(Board board) {
        this.board = board;
    }

    @FXML
    public void spelerToevoegen(){
        new SpelerCreator(board);
    }

    @FXML
    public void startSpel(){
        board.startSpel();
    }

}
