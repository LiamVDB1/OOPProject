package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.tileCards.ChestCard;
import be.ugent.objprog.ugentopoly.tileMidCards.ChestMidCard;
import be.ugent.objprog.ugentopoly.TileCard;
import be.ugent.objprog.ugentopoly.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.Board;
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
