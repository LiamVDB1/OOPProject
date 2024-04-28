package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.layout.CurrentSpelerLayout;
import be.ugent.objprog.ugentopoly.layout.SpelerInfo;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Speler implements Observable {
    private String naam;
    private Pion pion;
    private ImageView pionImage;
    private Color color;
    private BoardModel boardModel;
    private int saldo;
    private int positie;
    private int gevangenisBeurten;
    private boolean inGevangenis;
    private boolean dubbelGegooid;
    private boolean failliet;
    private List<Tile> properties;
    private List<InvalidationListener> listeners;
    private int spelerIndex;
    private SpelerInfo spelerInfo;
    private CurrentSpelerLayout currentSpelerLayout;
    private boolean whiteText;

    public Speler(String naam, Pion pion, Color color, BoardModel boardModel){
        this.naam = naam; this.pion = pion; this.color = color; this.boardModel = boardModel;
        saldo = boardModel.getStartBalance();
        positie = boardModel.getStartPosition();
        gevangenisBeurten = 0;
        inGevangenis = false;
        dubbelGegooid = false;
        failliet = false;
        properties = new ArrayList<>();
        listeners = new ArrayList<>();
        spelerInfo = new SpelerInfo(this);
        currentSpelerLayout = new CurrentSpelerLayout(this);
        whiteText = ! (ColorHelper.calculateLuminance(color) > 0.4);
        pionImage = new ImageView(pion.getImage());
        pionImage.setPreserveRatio(true);
        pionImage.setFitWidth(34);
    }

    public Color getColor(){
        return color;
    }
    public String getNaam(){
        return naam;
    }
    public Pion getPion(){
        return pion;
    }
    public int getSaldo(){
        return saldo;
    }
    public int getPositie(){ return positie; };
    public Tile getCurrentTile() {
        return boardModel.getTile(positie);
    }
    public String getPositieNaam(){
        return getCurrentTile().getText();
    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {
        listeners.add(invalidationListener);
    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {
        listeners.remove(invalidationListener);
    }

    public void fireInvalidationEvent(){
        for (InvalidationListener listener : listeners){
            listener.invalidated(this);
        }
    }

    public List<Tile> getProperties(){
        return properties;
    }

    public void addProperty(Tile tile){
        if (tile != null) {
            properties.add(tile);
            fireInvalidationEvent(); //Niet mogelijk dat de property al in de collection zit
        }
    }

    public void setSpelerIndex(int index){
        spelerIndex = index;
    }

    public int getSpelerIndex(){
        return spelerIndex;
    }

    public Button getSpelerButton(){
        Button button = new Button(naam);
        button.setStyle("-fx-background-color: " + ColorHelper.toHexString(color) + ";");
        button.setOnAction(e -> boardModel.getController().showSpelerInfo(this));
        return button;
    }

    public SpelerInfo getSpelerInfo(){
        return spelerInfo;
    }
    public CurrentSpelerLayout getCurrentSpelerLayout(){
        return currentSpelerLayout;
    }

    public boolean getWhiteText(){
        return whiteText;
    }

    public ImageView getPionImage(){
        return pionImage;
    }

    public void movePion(int steps){
        positie = (positie + steps) % 40; // altijd 40 tiles.
    }
}
