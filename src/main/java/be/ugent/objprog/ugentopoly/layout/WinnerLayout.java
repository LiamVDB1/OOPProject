package be.ugent.objprog.ugentopoly.layout;

import be.ugent.objprog.ugentopoly.Card;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WinnerLayout extends Card{
    private final String winnerNaam;
    private final Image winnerPion;
    private final int saldo;
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

        Label winnerLabel = labelWAnchors("Gefeliciteerd " + winnerNaam + "!", 100.0, 0.0, 0.0, null);
        winnerLabel.setPadding(new Insets(0, 5, 0, 5));
        Label saldoLabel = labelWAnchors("Je hebt gewonnen met een saldo van " + saldo + "!", 125.0, 0.0, 0.0, null);
        saldoLabel.setPadding(new Insets(0, 5, 0, 5));
        ImageView trophy= imageViewWAnchors(imageCreate("winner-trophy.png"), null, 107.5, 107.5, 5.0);
        trophy.setFitWidth(110);

        this.getChildren().addAll(pionImage, winnerLabel, saldoLabel, trophy);
    }
}
