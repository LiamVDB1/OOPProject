package be.ugent.objprog.ugentopoly;

import javafx.scene.paint.Color;

public class Speler {
    private String naam;
    private ChoiceItem pion;
    private Color color;
    private BoardModel boardModel;
    private int saldo;
    private int positie;
    private int gevangenisBeurten;
    private boolean inGevangenis;
    private boolean dubbelGegooid;
    private boolean failliet;

    public Speler(String naam,ChoiceItem pion, Color color, BoardModel boardModel){
        this.naam = naam; this.pion = pion; this.color = color; this.boardModel = boardModel;
        saldo = boardModel.getStartBalance();
        positie = 0;
        gevangenisBeurten = 0;
        inGevangenis = false;
        dubbelGegooid = false;
        failliet = false;
    }

    public Color getColor(){
        return color;
    }
    public String getNaam(){
        return naam;
    }
    public ChoiceItem getPion(){
        return pion;
    }
    public int getSaldo(){
        return saldo;
    }
    public String getPositieNaam(){
        return boardModel.getTile(positie).getText();
    }
}
