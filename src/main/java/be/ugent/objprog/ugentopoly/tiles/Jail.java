package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.tileCards.JailCard;
import be.ugent.objprog.ugentopoly.tileMidCards.JailMidCard;
import be.ugent.objprog.ugentopoly.TileCard;
import be.ugent.objprog.ugentopoly.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.Board;
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
        TileCard card = new JailCard(this, Parent, gridPos);
        this.card = card;
        return card;
    }
}
