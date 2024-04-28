package be.ugent.objprog.ugentopoly.layout;

import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.Speler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class CurrentSpelerLayout extends Card{
    private Speler speler;
    public CurrentSpelerLayout(Speler speler) {
        this.speler = speler;
        this.getStyleClass().add("infoTabPane");
        initialize();
    }
    public void initialize(){
        ImageView imageView = imageViewWAnchors(speler.getPion().getImage(), 5.0, 10.0, null, 5.0);
        imageView.setFitHeight(66);

        Label infoText = labelWAnchors("Nu aan de beurt:", 5.0, 65.0, 5.0, null);
        infoText.setPrefWidth(206);

        Label spelerNaam = labelWAnchors(speler.getNaam(), 23.0, 65.0, 5.0, null);
        spelerNaam.setPrefSize(206, 48);

        this.getChildren().addAll(imageView, infoText, spelerNaam);
    }
}
