package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class BoardView implements InvalidationListener {
    //UI elementen
    /*
    private final BorderPane board;
    private final GridPane top;
    private final GridPane left;
    private final StackPane center;
    private final GridPane right;
    private final GridPane bottom
    */
    private final AnchorPane cardPane;
    private final AnchorPane boardShow;
    private final AnchorPane tileShow;

    private TileMidCard prevViewedCard;

    public BoardView(BorderPane board, GridPane top, GridPane left, StackPane center, GridPane right, GridPane bottom, AnchorPane cardPane, AnchorPane boardShow, AnchorPane tileShow) {
        //this.board = board; this.top = top; this.left = left; this.center = center; this.right = right; this.bottom = bottom;

        this.cardPane = cardPane; this.boardShow = boardShow; this.tileShow = tileShow;
    }

    public void placeCard(Card card, GridPane parent, int gridPos1, int gridPos2){
        parent.add(card, gridPos1, gridPos2);
    }

    public void showTile(TileMidCard card){
        //
    }

    @Override
    public void invalidated(Observable observable) {
        //
    }
}
