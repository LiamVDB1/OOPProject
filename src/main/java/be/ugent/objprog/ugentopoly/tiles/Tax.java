package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.tileCards.TaxCard;
import be.ugent.objprog.ugentopoly.tileMidCards.TaxMidCard;
import be.ugent.objprog.ugentopoly.TileCard;
import be.ugent.objprog.ugentopoly.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.Board;
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
        TileCard card =  new TaxCard(this, Parent, gridPos, vertical, LT);
        this.card = card;
        return card;
    }
}
