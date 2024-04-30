package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.layout.tileCards.FreeParkingCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.FreeParkingMidCard;
import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;

public class FreeParking extends Tile{
    public FreeParking(int position, String id, BoardModel bord){
        super(position, id, bord);
        imageCreate("free_parking.png");
    }

    @Override
    public void initializeCards() {
        this.card = new FreeParkingCard(this);
        this.midCard = new FreeParkingMidCard(this);
    }

    @Override
    public void action() {
        boardModel.giveBonusPot(boardModel.getCurrentSpeler(), this);
    }
}
