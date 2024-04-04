package be.ugent.objprog.ugentopoly;

import javafx.scene.layout.GridPane;

public class Chest extends Tile{
    public Chest(int position, String id, GridPane Parent, Board bord){
        super(position, id, Parent, bord);
    }

    @Override
    public TileMidCard getMidCard() {
        return new ChestMidCard(this);
    }

    @Override
    public TileCard makeCard() {
        TileCard card = new ChestCard(this, Parent, gridPos,vertical, LT);
        this.card = card;
        return card;
    }
}
