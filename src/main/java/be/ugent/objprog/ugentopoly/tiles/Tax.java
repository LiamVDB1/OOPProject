package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.layout.tileCards.TaxCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TaxMidCard;
import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;

public class Tax extends Tile{
    int amount;
    public Tax(int position, String id, int amount, BoardModel bord){
        super(position, id, bord);
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    @Override
    public void initializeCards() {
        this.card = new TaxCard(this, vertical, LT);
        this.midCard = new TaxMidCard(this);
    }
}
