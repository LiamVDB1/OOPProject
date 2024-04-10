package be.ugent.objprog.ugentopoly.fxmlControllers;

import be.ugent.objprog.dice.Dice;
import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.StartGame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UgentopolyController{

    BoardModel boardModel;
    @FXML BorderPane borderPane;
    @FXML GridPane top;
    @FXML GridPane left;
    @FXML StackPane center;
    @FXML GridPane  right;
    @FXML GridPane bottom;

    @FXML AnchorPane cardPane;

    @FXML AnchorPane tileShow;
    @FXML AnchorPane boardShow;
    public void initialize() {
        //Bord initaliseren
        boardModel = new BoardModel(this.borderPane, this.top, this.left, this.center, this.right, this.bottom, this.cardPane, this.boardShow, this.tileShow);
    }

    @FXML
    public void toBoard(){
        boardModel.showBoard();
    }
}
