package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileCards.GoToJailCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.GoToJailMidCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;

public class GoToJail extends Tile{
    public GoToJail(int position, String id, BoardModel bord){
        super(position, id, bord);
        imageCreate("go_to_jail.png");
    }

    @Override
    public void initializeCards() {
        this.card = new GoToJailCard(this);
        this.midCard = new GoToJailMidCard(this);
    }

    @Override
    public void action() {
        boardModel.goToJail(boardModel.getCurrentSpeler());
    }
}