package be.ugent.objprog.ugentopoly;

import javafx.scene.layout.GridPane;

public class Tax extends Tile{
    int amount;
    public Tax(int position, String id, int amount, GridPane Parent, Board bord){
        super(position, id, Parent, bord);
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    @Override
    public TileMidCard getMidCard() {
        return new TaxMidCard(this);
    }

    @Override
    public TileCard makeCard() {
        return new TaxCard(this, Parent, gridPos, vertical, LT);
    }
}
