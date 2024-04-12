package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileCards.ChestCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.ChestMidCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.Board;

public class Chest extends Tile{
    public Chest(int position, String id, Board bord){
        super(position, id, bord);
        Card card = new ChestCard(this, vertical, LT);
        this.card = card;
    }

    @Override
    public TileMidCard getMidCard() {
        return new ChestMidCard(this);
    }
}
