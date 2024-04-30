package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.layout.CurrentSpelerLayout;
import be.ugent.objprog.ugentopoly.layout.SpelerInfo;
import be.ugent.objprog.ugentopoly.tiles.Railway;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import be.ugent.objprog.ugentopoly.tiles.Utility;
import javafx.beans.InvalidationListener;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Speler {
    private String naam;
    private Pion pion;
    private ImageView pionImage;
    private Color color;
    private BoardModel boardModel;
    private int saldo;
    private int positie;
    private int gevangenisBeurten;
    private boolean inGevangenis;
    private List<Tile> properties;
    private List<InvalidationListener> listeners;
    private int spelerIndex;
    private SpelerInfo spelerInfo;
    private CurrentSpelerLayout currentSpelerLayout;
    private boolean whiteText;
    private List<Railway>  railways;
    private List<Utility> utilities;
    private int dubbelGegooidCounter;
    public Speler(String naam, Pion pion, Color color, BoardModel boardModel){
        this.naam = naam; this.pion = pion; this.color = color; this.boardModel = boardModel;
        saldo = boardModel.getStartBalance();
        positie = boardModel.getStartPosition();
        gevangenisBeurten = 0;
        inGevangenis = false;
        properties = new ArrayList<>();
        listeners = new ArrayList<>();
        spelerInfo = new SpelerInfo(this);
        currentSpelerLayout = new CurrentSpelerLayout(this);
        whiteText = ! (ColorHelper.calculateLuminance(color) > 0.4);
        pionImage = new ImageView(pion.getImage());
        pionImage.setPreserveRatio(true);
        pionImage.setFitWidth(34);
        railways = new ArrayList<>();
        utilities = new ArrayList<>();
        dubbelGegooidCounter = 0;
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
    public int getDubbelGegooidCounter(){
        return dubbelGegooidCounter;
    }

    public List<Tile> getProperties(){
        return properties;
    }
    public List<Utility> getUtilities(){
        return utilities;
    }
    public List<Railway> getRailways(){
        return railways;
    }

    public void addProperty(Tile tile){
        if (tile != null) {
            properties.add(tile);
            spelerInfo.updateListView();
        }
    }
    public void addDubbelGegooid(){
        dubbelGegooidCounter++;
    }
    public void notDubbelGeGooid(){
        dubbelGegooidCounter = 0;
    }

    public void updateSaldo(int amount){
        saldo += amount;
        spelerInfo.updateSaldo();
        if (saldo < 0){
            boardModel.showFailliet(this);
        }
    }

    public void addRailway(Railway railway){
        railways.add(railway);
    }

    public void addUtility(Utility utility){
        utilities.add(utility);
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

    public void setPosition(int positie){
        this.positie = positie;
        spelerInfo.updatePositie();

    }

    public void movePion(int steps){
        positie = (positie + steps) % 40; // altijd 40 tiles.
        spelerInfo.updatePositie();
    }
}
