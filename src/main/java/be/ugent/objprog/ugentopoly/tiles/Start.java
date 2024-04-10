package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.layout.tileCards.StartCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.StartMidCard;
import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;

public class Start extends Tile {
    public Start(int position, String id, BoardModel bord) {
        super(position, id, bord);
    }

    @Override
    public void initializeCards() {
        this.card = new StartCard(this);
        this.midCard = new StartMidCard(this);
    }
}
