package be.ugent.objprog.ugentopoly;

public class Speler {
    private String naam;
    private int geld;
    private int positie;
    private int gevangenisBeurten;
    private boolean inGevangenis;
    private boolean dubbelGegooid;
    private boolean failliet;

    public Speler(String naam, BoardModel boardModel){
        this.naam = naam;
        geld = boardModel.getStartBalance();
        positie = 0;
        gevangenisBeurten = 0;
        inGevangenis = false;
        dubbelGegooid = false;
        failliet = false;
    }
}
