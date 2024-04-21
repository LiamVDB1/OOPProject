package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.layout.tileCards.UtilityCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.UtilityMidCard;

public class Utility extends Tile{
    int cost;
    public Utility(int position, String id, int cost, BoardModel bord){
        super(position, id, bord);
        this.cost = cost;
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
    }

    public int getCost(){
        return cost;
    }

    public int getNr(){
        return Integer.parseInt(id.substring(id.length() - 1));
    }
}
