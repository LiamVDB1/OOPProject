package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.layout.DiceLayout;
import be.ugent.objprog.ugentopoly.layout.LogLayout;
import be.ugent.objprog.ugentopoly.layout.tileCards.TileCards;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.util.Map;

public class BoardView implements InvalidationListener {
    private final BoardModel model;
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
    private final AnchorPane infoTab;

    public BoardView(BoardModel model, BorderPane spelBord, GridPane top, GridPane left, StackPane center, GridPane right, GridPane bottom, AnchorPane cardPane, AnchorPane boardShow, AnchorPane tileShow, AnchorPane infoTab) {
        this.model = model;
        this.spelBord = spelBord;
        //this.top = top; this.left = left; this.center = center; this.right = right; this.bottom = bottom;

        this.cardPane = cardPane; this.boardShow = boardShow; this.tileShow = tileShow; this.infoTab = infoTab;
        initialize();
        temp(1, 0.0);
        temp(5, 50.0);
        temp(10, 100.0);
        temp(20, 150.0);
        temp(30, 200.0);
        temp(40, 250.0);
    }

    public void initialize(){
        setDice();
        setLog();
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

    public void setDice(){
        DiceLayout diceLayout = new DiceLayout(model.getController());
        boardShow.getChildren().add(diceLayout);
        AnchorPane.setTopAnchor(diceLayout, 260.0);
        AnchorPane.setLeftAnchor(diceLayout, 120.0);
    }

    public void setLog(){
        LogLayout logLayout = new LogLayout();
        AnchorPane.setTopAnchor(logLayout, 450.0);
        AnchorPane.setLeftAnchor(logLayout, 7.5);
        AnchorPane.setRightAnchor(logLayout, 7.5);
        infoTab.getChildren().add(logLayout);
    }

    public void placeButton(Button button, int spelerIndex, boolean whiteText){
        Map<Integer, Double> buttonLeftAnchor = Map.of(
                0, 17.5,
                1, 82.5,
                2, 147.5,
                3, 212.5
        );
        button.setWrapText(true);
        if (whiteText) { button.setTextFill(Color.WHITE); }
        button.setTextAlignment(TextAlignment.CENTER);
        button.setPrefSize(65, 50);
        AnchorPane.setLeftAnchor(button, buttonLeftAnchor.get(spelerIndex));
        AnchorPane.setTopAnchor(button, 10.0);
        infoTab.getChildren().add(button);
    }

    public void placeSpelerInfo(AnchorPane anchorPane){
        AnchorPane.setTopAnchor(anchorPane, 61.0);
        AnchorPane.setLeftAnchor(anchorPane, 7.5);
        AnchorPane.setRightAnchor(anchorPane, 7.5);
        anchorPane.setVisible(false);
        infoTab.getChildren().add(anchorPane);
    }

    public void placeCurrentSpelerLayout(AnchorPane anchorPane){
        AnchorPane.setTopAnchor(anchorPane, 755.0);
        AnchorPane.setLeftAnchor(anchorPane, 7.5);
        AnchorPane.setRightAnchor(anchorPane, 7.5);
        anchorPane.setVisible(false);
        infoTab.getChildren().add(anchorPane);
    }

    public void showSpelerInfo(AnchorPane oldSpelerInfo, AnchorPane newSpelerInfo){
        if (oldSpelerInfo != null){
            oldSpelerInfo.setVisible(false);
        }
        if (! newSpelerInfo.isVisible()){
            newSpelerInfo.setVisible(true);
        }
    }

    public void showCurrentSpeler(AnchorPane oldCurrentSpeler, AnchorPane newCurrentSpeler){
        if (oldCurrentSpeler != null){
            oldCurrentSpeler.setVisible(false);
        }
        if (! newCurrentSpeler.isVisible()){
            newCurrentSpeler.setVisible(true);
        }
    }

    public void placePion(ImageView pionImage, TileCards tileCard, int spelerIndex){
        Map<Integer, Double> spelerAnchor = Map.of(
                0, 4.0,
                1, 39.0,
                2, 74.0,
                3, 109.0
        );
        tileCard.setPion(pionImage, spelerAnchor.get(spelerIndex));
    }

    public void removePion(ImageView pionImage, TileCards tileCard){
        tileCard.removePion(pionImage);
    }

    public void temp(int amount, double leftAnchor){
        Button button = new Button();
        button.setText("Move" + amount);
        button.setOnAction(e -> model.moveSpeler(amount));
        AnchorPane.setLeftAnchor(button, leftAnchor);
        boardShow.getChildren().add(button);
    }
}
