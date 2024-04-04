package be.ugent.objprog.ugentopoly;

import javafx.scene.layout.GridPane;

public class Chance extends Tile{
    public Chance(int position, String id, GridPane Parent, Board bord){
        super(position, id, Parent, bord);
    }

    @Override
    public TileMidCard getMidCard() {
        return new ChanceMidCard(this);
    }


    @Override
    public TileCard makeCard() {
        TileCard card = new ChanceCard(this, Parent, gridPos,vertical, LT);
        this.card = card;
        return card;
    }
}
