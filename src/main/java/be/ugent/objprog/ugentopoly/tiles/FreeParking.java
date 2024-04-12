package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.layout.tileCards.FreeParkingCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.FreeParkingMidCard;
import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.Board;

public class FreeParking extends Tile{
    public FreeParking(int position, String id, Board bord){
        super(position, id, bord);
        Card card = new FreeParkingCard(this);
        this.card = card;
    }

    @Override
    public TileMidCard getMidCard() {
        return new FreeParkingMidCard(this);
    }
}
