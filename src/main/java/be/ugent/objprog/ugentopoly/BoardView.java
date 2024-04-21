package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.layout.DiceLayout;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class BoardView implements InvalidationListener {
    private BoardModel model;
    private final BorderPane spelBord;
    //UI elementen
    /*
    private final GridPane top;
    private final GridPane left;
    private final StackPane center;
    private final GridPane right;
    private final GridPane bottom
    */
    private final AnchorPane cardPane;
    private final AnchorPane boardShow;
    private final AnchorPane tileShow;

    public BoardView(BoardModel model, BorderPane spelBord, GridPane top, GridPane left, StackPane center, GridPane right, GridPane bottom, AnchorPane cardPane, AnchorPane boardShow, AnchorPane tileShow) {
        this.model = model;
        this.spelBord = spelBord;
        //this.top = top; this.left = left; this.center = center; this.right = right; this.bottom = bottom;

        this.cardPane = cardPane; this.boardShow = boardShow; this.tileShow = tileShow;
        DiceLayout diceLayout = new DiceLayout();
        boardShow.getChildren().add(diceLayout);
        AnchorPane.setTopAnchor(diceLayout, 260.0);
        AnchorPane.setLeftAnchor(diceLayout, 120.0);
    }

    public BorderPane getSpelBord(){
        return spelBord;
    }

    public void placeCard(Card card, GridPane parent, int gridPos1, int gridPos2){
        parent.add(card, gridPos1, gridPos2);
    }

    public void showTile(Tile prevTile, Tile tile){
        if (prevTile != null){
            prevTile.getCard().getStyleClass().remove("selected");
        }
        if (tile != null){
            if (tile == prevTile){
                showBoard(prevTile);
            } else {
                cardPane.getChildren().clear();
                cardPane.getChildren().add(tile.getMidCard());

                if (boardShow.isVisible()){
                    boardShow.setVisible(false);
                    tileShow.setVisible(true);
                }
                tile.getCard().getStyleClass().add("selected");
                model.setPrevTile(tile);
            }
        }
    }

    public void showBoard(Tile prevTile){
        if (prevTile != null){
            prevTile.getCard().getStyleClass().remove("selected");
        }
        if (! boardShow.isVisible()){
            tileShow.setVisible(false);
            boardShow.setVisible(true);
            model.setPrevTile(null);
        }
    }

    @Override
    public void invalidated(Observable observable) {
        //
    }
}
