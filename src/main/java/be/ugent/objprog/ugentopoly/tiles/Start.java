package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.layout.tileCards.StartCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.StartMidCard;
import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.Board;

public class Start extends Tile {
    public Start(int position, String id, Board bord) {
        super(position, id, bord);
        Card card =  new StartCard(this);
        this.card = card;
    }

    @Override
    public TileMidCard getMidCard() { return new StartMidCard(this); }
}
