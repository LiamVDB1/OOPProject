package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.layout.tileCards.ChanceCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.ChanceMidCard;
import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.Board;

public class Chance extends Tile{
    public Chance(int position, String id, Board bord){
        super(position, id, bord);
        Card card = new ChanceCard(this, vertical, LT);
        this.card = card;
    }

    @Override
    public TileMidCard getMidCard() {
        return new ChanceMidCard(this);
    }
}
