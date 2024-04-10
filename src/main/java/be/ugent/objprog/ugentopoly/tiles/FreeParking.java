package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.tileCards.FreeParkingCard;
import be.ugent.objprog.ugentopoly.tileMidCards.FreeParkingMidCard;
import be.ugent.objprog.ugentopoly.TileCard;
import be.ugent.objprog.ugentopoly.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.Board;
import javafx.scene.layout.GridPane;

public class FreeParking extends Tile{
    public FreeParking(int position, String id, GridPane Parent, Board bord){
        super(position, id, Parent, bord);
    }

    @Override
    public TileMidCard getMidCard() {
        return new FreeParkingMidCard(this);
    }

    @Override
    public TileCard makeCard() {
        TileCard card = new FreeParkingCard(this, Parent, gridPos);
        this.card = card;
        return card;
    }
}
