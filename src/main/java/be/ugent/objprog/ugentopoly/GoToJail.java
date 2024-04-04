package be.ugent.objprog.ugentopoly;

import javafx.scene.layout.GridPane;

public class GoToJail extends Tile{
    public GoToJail(int position, String id, GridPane Parent, Board bord){
        super(position, id, Parent, bord);
    }

    @Override
    public TileMidCard getMidCard() {
        return new GoToJailMidCard(this);
    }

    @Override
    public TileCard makeCard() {
        TileCard card = new GoToJailCard(this, Parent, gridPos);
        this.card = card;
        return card;
    }
}
