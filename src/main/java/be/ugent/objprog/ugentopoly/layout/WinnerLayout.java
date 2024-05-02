package be.ugent.objprog.ugentopoly.layout;

import be.ugent.objprog.ugentopoly.Card;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WinnerLayout extends Card{
    private String winnerNaam;
    private Image winnerPion;
    private int saldo;
    public WinnerLayout(String winnerNaam, Image winnerPion, int saldo) {
        this.winnerNaam = winnerNaam;
        this.winnerPion = winnerPion;
        this.saldo = saldo;
        initialize();
    }

    private void initialize() {
        this.setPrefSize(325.0, 275.0);
        ImageView pionImage = imageViewWAnchors(winnerPion, 5.0, 132.5,  132.5, null);
        pionImage.setFitWidth(60);

        Label winnerLabel = labelWAnchors("Gefeliciteerd " + winnerNaam + "!", null, 0.0, 0.0, 155.0);
        Label saldoLabel = labelWAnchors("Je hebt gewonnen met een saldo van " + saldo + "!", null, 0.0, 0.0, 130.0);
        ImageView trophy= imageViewWAnchors(imageCreate("winner-trophy.png"), null, 102.5, 102.5, 10.0);
        trophy.setFitWidth(120);

        this.getChildren().addAll(pionImage, winnerLabel, saldoLabel, trophy);
    }
}
