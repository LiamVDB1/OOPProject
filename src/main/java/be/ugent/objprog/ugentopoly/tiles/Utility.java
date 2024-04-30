package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.Speler;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.layout.tileCards.UtilityCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.UtilityMidCard;

public class Utility extends Eigendom{
    private int multiplyHuur;
    public Utility(int position, String id, int cost, BoardModel bord){
        super(position, id, bord ,cost, -1);
        if (getNr() == 1){
            imageCreate("utility1.png");
        } else {
            imageCreate("utility2.png");
        }
    }

    @Override
    public void initializeCards() {
        this.card = new UtilityCard(this, vertical, LT);
        this.midCard = new UtilityMidCard(this);
        this.multiplyHuur = 4;
    }
    public int getNr(){
        return Integer.parseInt(id.substring(id.length() - 1));
    }

    public void setMultiplyHuur(int multiplyHuur){
        this.multiplyHuur = multiplyHuur;
    }

    @Override
    public void setEigenaar(Speler speler){
        super.setEigenaar(speler);
        speler.addUtility(this);
        if (speler.getUtilities().size() == 2){
            speler.getUtilities().forEach(utility -> utility.setMultiplyHuur(10));
        } else {
            speler.getUtilities().forEach(utility -> utility.setMultiplyHuur(4));
        }
    }
    @Override
    public void action(){
        setHuur(multiplyHuur * boardModel.getLaatsteWorp());
        super.action();
    }
}
