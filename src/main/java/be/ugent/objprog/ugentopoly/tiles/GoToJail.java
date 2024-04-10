package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.tileCards.GoToJailCard;
import be.ugent.objprog.ugentopoly.tileMidCards.GoToJailMidCard;
import be.ugent.objprog.ugentopoly.TileCard;
import be.ugent.objprog.ugentopoly.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.Board;
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
