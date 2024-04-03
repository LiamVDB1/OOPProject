package be.ugent.objprog.ugentopoly;

import javafx.scene.layout.GridPane;

public class Jail extends Tile{
    public Jail(int position, String id, GridPane Parent, Board bord){
        super(position, id, Parent, bord);
    }

    @Override
    public TileMidCard getMidCard() {
        return new JailMidCard(this);
    }

    @Override
    public TileCard makeCard() {
        return new JailCard(this, Parent, gridPos);
    }
}
