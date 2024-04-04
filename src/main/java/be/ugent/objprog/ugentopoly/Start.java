package be.ugent.objprog.ugentopoly;

import javafx.scene.layout.GridPane;

public class Start extends Tile {
    public Start(int position, String id, GridPane Parent, Board bord) {
        super(position, id , Parent, bord);
    }

    @Override
    public TileMidCard getMidCard() {
        return new StartMidCard(this);
    }

    @Override
    public TileCard makeCard() {
        TileCard card =  new StartCard(this, Parent, gridPos);
        this.card = card;
        return card;
    }
}
