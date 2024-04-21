package be.ugent.objprog.ugentopoly.layout;

import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.Speler;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class SpelerInfo extends Card {
    private Speler speler;
    public SpelerInfo(Speler speler) {
        this.speler = speler;
        initialize();
    }
    public void initialize(){
        Label saldo = everyLabel("Saldo: " + speler.getSaldo());

        Label positie1 = everyLabel("Positie: ");

        Label positie2 = everyLabel(speler.getPositieNaam());

        ImageView image = new ImageView(speler.getPion().getImage());

        ListView<Tile> listView = new ListView<Tile>();

        this.getChildren().addAll(saldo, positie1, positie2, image, listView);
    }
}
