package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.layout.tileCards.ChanceCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.ChanceMidCard;
import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;

public class Chance extends Tile{
    public Chance(int position, String id, BoardModel bord){
        super(position, id, bord);
        imageCreate("chance.png");
    }

    @Override
    public void initializeCards() {
        this.card = new ChanceCard(this, vertical, LT);
        this.midCard = new ChanceMidCard(this);
    }

    @Override
    public void action() {
        //TODO
    }
}
