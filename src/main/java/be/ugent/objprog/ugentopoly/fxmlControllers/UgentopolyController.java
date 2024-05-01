package be.ugent.objprog.ugentopoly.fxmlControllers;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.Speler;
import be.ugent.objprog.ugentopoly.tiles.Eigendom;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.util.List;

public class UgentopolyController{

    private BoardModel boardModel;
    private @FXML BorderPane borderPane;
    private @FXML GridPane top;
    private @FXML GridPane left;
    private @FXML StackPane center;
    private @FXML GridPane  right;
    private @FXML GridPane bottom;

    private @FXML AnchorPane cardPane;

    private @FXML AnchorPane tileShow;
    private @FXML AnchorPane boardShow;
    private @FXML AnchorPane infoTab;

    private boolean isShowBoardEnabled;
    private boolean isShowTileEnabled;
    public void initialize() {
        //Bord initaliseren
        boardModel = new BoardModel(this, this.borderPane, this.top, this.left, this.center, this.right, this.bottom, this.cardPane, this.boardShow, this.tileShow, this.infoTab);
        isShowBoardEnabled = true;
        isShowTileEnabled = true;
    }

    @FXML
    public void showBoard(){
        if (isShowBoardEnabled) {
            boardModel.showBoard();
        }
    }
    public void showTile(Tile tile){
        if (isShowTileEnabled){
            boardModel.showTile(tile);
        }
    }

    public void showSpelerInfo(Speler speler) { boardModel.showSpelerInfo(speler); }

    public void moveSpeler(List<Integer> list) {
        boardModel.moveSpeler(list.get(0) + list.get(1), list.get(0) == list.get(1));
    }

    public void setShowBoardEnabledAndTileEnabled(boolean enabled) {
        isShowBoardEnabled = enabled;
        isShowTileEnabled = enabled;
    }

    public void skipEigendom(){
        setShowBoardEnabledAndTileEnabled(true);
        showBoard();
    }
    public void buyEigendom(Eigendom eigendom){
        setShowBoardEnabledAndTileEnabled(true);
        boardModel.buyEigendom(eigendom);
        showBoard();
    }
}
