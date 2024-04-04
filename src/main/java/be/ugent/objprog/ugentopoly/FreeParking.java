package be.ugent.objprog.ugentopoly;

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
