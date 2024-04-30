package be.ugent.objprog.ugentopoly.layout;

import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.Speler;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class SpelerInfo extends Card {
    private Speler speler;
    private Label saldo;
    private Label positie2;
    private ListView<Tile> listView;
    public SpelerInfo(Speler speler) {
        this.speler = speler;
        this.getStyleClass().add("infoTabPane");
        initialize();
    }
    public void initialize(){
        saldo = labelWAnchors("Saldo: " + speler.getSaldo(), 5.0, 5.0, null, null);

        Label positie1 = labelWAnchors("Positie: ", 30.0, 5.0, null, null);

        positie2 = labelWAnchors(speler.getPositieNaam(), 30.0, 60.0, null, null);

        ImageView image = imageViewWAnchors(speler.getPion().getImage(), 5.0, null, 25.0, null);
        image.setFitHeight(55);

        listView = new ListView<>();
        setupListView(listView);

        this.getChildren().addAll(saldo, positie1, positie2, image, listView);
    }

    public void updateListView(){
        listView.getItems().clear();
        listView.getItems().addAll(speler.getProperties());
    }

    public void updateSaldo(){
        this.saldo.setText("Saldo: " + speler.getSaldo());
    }

    public void updatePositie(){
        this.positie2.setText(speler.getPositieNaam());
    }

    public void setupListView(ListView<Tile> listView){
        listView.setPrefSize(266, 300);
        AnchorPane.setTopAnchor(listView, 70.0);
        AnchorPane.setLeftAnchor(listView, 5.0);
        AnchorPane.setRightAnchor(listView, 5.0);
        AnchorPane.setBottomAnchor(listView, 10.0);
        listView.setFixedCellSize(25.0);

        listView.setCellFactory(o -> new ListCell<Tile>() {
            @Override
            protected void updateItem(Tile item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item.getText());
                    setGraphic(item.getGraphic());
                }
            }
        });
    }
}
