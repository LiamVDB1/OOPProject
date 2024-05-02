package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.layout.BuyOrSkipLayout;
import be.ugent.objprog.ugentopoly.layout.DiceLayout;
import be.ugent.objprog.ugentopoly.layout.LogLayout;
import be.ugent.objprog.ugentopoly.layout.WinnerLayout;
import be.ugent.objprog.ugentopoly.layout.tileCards.TileCards;
import be.ugent.objprog.ugentopoly.tiles.Eigendom;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.util.Map;

public class BoardView {
    private final BoardModel model;
    private final BorderPane spelBord;
    private final AnchorPane cardPane;
    private final AnchorPane boardShow;
    private final AnchorPane tileShow;
    private final AnchorPane endGame;
    private final AnchorPane endGameInfo;
    private final AnchorPane infoTab;
    private BuyOrSkipLayout buyOrSkip;

    public BoardView(BoardModel model, BorderPane spelBord, AnchorPane endGame, AnchorPane endGameInfo, AnchorPane cardPane, AnchorPane boardShow, AnchorPane tileShow, AnchorPane infoTab) {
        this.model = model;
        this.spelBord = spelBord;
        this.cardPane = cardPane; this.boardShow = boardShow; this.tileShow = tileShow; this.infoTab = infoTab;
        this.endGame = endGame; this.endGameInfo = endGameInfo;
        initialize();
    }

    //Initialize Section
    public void initialize(){
        setDice();
        setLog();
        setBuyOrSkip();
    }

    public void placeCard(Card card, GridPane parent, int gridPos1, int gridPos2){
        parent.add(card, gridPos1, gridPos2);
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
        model.setLog(logLayout);
    }

    public void setBuyOrSkip(){
        buyOrSkip = new BuyOrSkipLayout(model.getController());
        AnchorPane.setTopAnchor(buyOrSkip, 124.5);
        AnchorPane.setLeftAnchor(buyOrSkip, 0.0);
        AnchorPane.setRightAnchor(buyOrSkip, 0.0);
        AnchorPane.setBottomAnchor(buyOrSkip, 124.5);
        buyOrSkip.setVisible(false);
        tileShow.getChildren().add(buyOrSkip);
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

    //Getters and Setters
    public BorderPane getSpelBord(){
        return spelBord;
    }

    //Start Spel Layout Section
    public void startSpelAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Spel Start");
        alert.setHeaderText("Het spel is gestart!");
        alert.setContentText("Het spel is gestart, veel plezier!\nOm te beginnen klik op de dobbelstenen om deze te gooien.");
        alert.showAndWait();
    }

    public void placeCurrentSpelerLayout(AnchorPane anchorPane){
        AnchorPane.setTopAnchor(anchorPane, 755.0);
        AnchorPane.setLeftAnchor(anchorPane, 7.5);
        AnchorPane.setRightAnchor(anchorPane, 7.5);
        anchorPane.setVisible(false);
        infoTab.getChildren().add(anchorPane);
    }

    //Board Layout Section
    public void showTile(Tile prevTile, Tile tile){
        model.getController().setShowBoardEnabledAndTileEnabled(true);
        buyOrSkip.setVisible(false);
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

    public void showBuying(Eigendom eigendom){
        buyOrSkip.setVisible(true);
        buyOrSkip.setTile(eigendom);
        model.getController().setShowBoardEnabledAndTileEnabled(false);
    }

    //Alerts Section
    private void showAlert(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    public void showBetaalHuur(Eigendom eigendom, Speler fromSpeler, Speler toSpeler){
        String header = fromSpeler.getNaam() + " heeft huur betaald aan " + toSpeler.getNaam();
        String content = fromSpeler.getNaam() + " heeft " + eigendom.getHuur() + "$ betaald aan " + toSpeler.getNaam() + " voor " + eigendom.getText();
        showAlert("Huur Betaald", header, content);
        model.getController().showBoard();
    }

    public void showTaxPaid(int amount, Speler speler){
        String header = speler.getNaam() + " heeft belasting betaald";
        String content = speler.getNaam() + " heeft " + amount + "$ belasting betaald";
        showAlert("Belasting Betaald", header, content);
        model.getController().showBoard();
    }

    public void showGaveBonusPot(Speler speler){
        String header = speler.getNaam() + " heeft de bonus pot gewonnen";
        String content = speler.getNaam() + " heeft " + model.getBonusPot() + "$ gewonnen";
        showAlert("Bonus Pot", header, content);
        model.getController().showBoard();
    }

    public void showToJail(Speler speler){
        String header = speler.getNaam() + " is naar de gevangenis gestuurd";
        String content = speler.getNaam() + " is naar de gevangenis gestuurd, gooi Dubbel om eruit te geraken";
        showAlert("Gevangenis", header, content);
        model.getController().showBoard();
    }

    public void escapedJail(Speler speler, boolean outOfJailCard){
        String header = speler.getNaam() + " is ontsnapt uit de gevangenis!";
        String content;
        if (outOfJailCard){
            content = speler.getNaam() + " moet niet naar de gevangenis door een get out of Jail kaart!";
        } else {
            content = speler.getNaam() + " is ontsnapt uit de gevangenis, en kan weer verder spelen!";
        }
        showAlert("Gevangenis", header, content);
        model.getController().showBoard();
    }

    public void showMoneyDeck(Speler speler, String text){
        String header = speler.getNaam() + " heeft een geld kaart getrokken!";
        showAlert("Geld Kaart", header, text);
        model.getController().showBoard();
    }

    public void showRelMoveCard(Speler speler, String text){
        String header = speler.getNaam() + " heeft een relatieve move kaart getrokken!";
        showAlert("Relatieve Move", header, text);
        model.getController().showBoard();
    }

    public void showMoveCard(Speler speler, String text){
        String header = speler.getNaam() + " heeft een move kaart getrokken!";
        showAlert("Move Kaart", header, text);
        model.getController().showBoard();
    }

    public void showPlayersMoneyDeck(Speler speler, String text){
        String header = speler.getNaam() + " heeft een geld kaart getrokken!";
        showAlert("Geld Kaart", header, text);
        model.getController().showBoard();
    }

    public void showJailDeck(Speler speler, String text){
        String header = speler.getNaam() + " heeft een get out of Jail kaart getrokken!";
        showAlert("Get Out of Jail", header, text);
        model.getController().showBoard();
    }

    public void showFailliet(Speler speler){
        String header = speler.getNaam() + " is failliet!";
        String content = speler.getNaam() + " is failliet en hierdoor is het spel gedaan.";
        showAlert("Failliet", header, content);
        model.getController().showBoard();
    }

    //End Game Logica
    public void showWinner(Speler speler) {
        this.endGameInfo.getChildren().add(new WinnerLayout(speler.getNaam(), speler.getPion().getImage(), speler.getSaldo()));
        this.endGame.setVisible(true);
        model.getController().setShowBoardEnabledAndTileEnabled(false);
        boardShow.setVisible(false);
        tileShow.setVisible(false);
    }
}
