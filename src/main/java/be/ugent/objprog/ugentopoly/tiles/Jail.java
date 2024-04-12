package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.layout.tileCards.JailCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.JailMidCard;
import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.Board;

public class Jail extends Tile{
    public Jail(int position, String id, Board bord){
        super(position, id, bord);
        Card card = new JailCard(this);
        this.card = card;
    }

    @Override
    public TileMidCard getMidCard() {
        return new JailMidCard(this);
    }
}
