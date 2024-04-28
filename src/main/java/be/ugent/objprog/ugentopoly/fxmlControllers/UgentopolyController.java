package be.ugent.objprog.ugentopoly.fxmlControllers;

import be.ugent.objprog.dice.Dice;
import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.Speler;
import be.ugent.objprog.ugentopoly.StartGame;
import be.ugent.objprog.ugentopoly.tiles.Tile;
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
import java.util.List;

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
    @FXML AnchorPane infoTab;
    public void initialize() {
        //Bord initaliseren
        boardModel = new BoardModel(this, this.borderPane, this.top, this.left, this.center, this.right, this.bottom, this.cardPane, this.boardShow, this.tileShow, this.infoTab);
    }

    @FXML
    public void toBoard(){
        boardModel.showBoard();
    }
    public void showTile(Tile tile){
        boardModel.showTile(tile);
    }

    public void showSpelerInfo(Speler speler) { boardModel.showSpelerInfo(speler); }

    public void moveSpeler(List<Integer> list) {
        boardModel.moveSpeler(list.get(0) + list.get(1));
    }
}
