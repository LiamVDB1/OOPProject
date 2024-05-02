package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.layout.tileCards.ChestCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.ChestMidCard;

public class Chest extends Tile{
    public Chest(int position, String id, BoardModel bord){
        super(position, id, bord);
        imageCreate("chest.png");
    }

    @Override
    public void initializeCards() {
        this.card = new ChestCard(this, vertical, LT);
        this.midCard = new ChestMidCard(this);
    }

    @Override
    public void action() {
        boardModel.takeChestCard(this);
    }
}
