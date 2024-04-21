package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.layout.tileCards.JailCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.JailMidCard;
import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;

public class Jail extends Tile{
    public Jail(int position, String id, BoardModel bord){
        super(position, id, bord);
        imageCreate("jail.png");
    }

    @Override
    public void initializeCards() {
        this.card = new JailCard(this);
        this.midCard = new JailMidCard(this);
    }
}
