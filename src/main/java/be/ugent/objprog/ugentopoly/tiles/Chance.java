package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.tileCards.ChanceCard;
import be.ugent.objprog.ugentopoly.tileMidCards.ChanceMidCard;
import be.ugent.objprog.ugentopoly.TileCard;
import be.ugent.objprog.ugentopoly.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.Board;
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
