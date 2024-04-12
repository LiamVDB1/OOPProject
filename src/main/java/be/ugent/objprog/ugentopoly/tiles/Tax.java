package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.layout.tileCards.TaxCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TaxMidCard;
import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.Board;

public class Tax extends Tile{
    int amount;
    public Tax(int position, String id, int amount, Board bord){
        super(position, id, bord);
        this.amount = amount;
        Card card =  new TaxCard(this, vertical, LT);
        this.card = card;
    }

    public int getAmount(){
        return amount;
    }

    @Override
    public TileMidCard getMidCard() {
        return new TaxMidCard(this);
    }
}
