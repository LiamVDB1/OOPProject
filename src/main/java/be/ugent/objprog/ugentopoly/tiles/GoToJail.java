package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileCards.GoToJailCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.GoToJailMidCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.Board;

public class GoToJail extends Tile{
    public GoToJail(int position, String id, Board bord){
        super(position, id, bord);
        Card card = new GoToJailCard(this);
        this.card = card;
    }

    @Override
    public TileMidCard getMidCard() {
        return new GoToJailMidCard(this);
    }
}
