package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.layout.tileCards.UtilityCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.UtilityMidCard;
import be.ugent.objprog.ugentopoly.Board;

public class Utility extends Tile{
    int cost;
    public Utility(int position, String id, int cost, Board bord){
        super(position, id, bord);
        this.cost = cost;
        Card card =  new UtilityCard(this, vertical, LT);
        this.card = card;
    }

    @Override
    public TileMidCard getMidCard() {
        return new UtilityMidCard(this);
    }

    public int getCost(){
        return cost;
    }

    public int getNr(){
        return Integer.parseInt(id.substring(id.length() - 1));
    }
}
