package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.TileCard;
import be.ugent.objprog.ugentopoly.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.tileCards.UtilityCard;
import be.ugent.objprog.ugentopoly.tileMidCards.UtilityMidCard;
import be.ugent.objprog.ugentopoly.Board;
import javafx.scene.layout.GridPane;

public class Utility extends Tile{
    int cost;
    public Utility(int position, String id, int cost, GridPane Parent, Board bord){
        super(position, id, Parent, bord);
        this.cost = cost;
    }

    @Override
    public TileMidCard getMidCard() {
        return new UtilityMidCard(this);
    }

    public int getCost(){
        return cost;
    }

    public int getNr(){
        return Integer.parseInt(id.substring(id.length() - 1));
    }

    @Override
    public TileCard makeCard() {
        TileCard card =  new UtilityCard(this, Parent, gridPos, vertical, LT);
        this.card = card;
        return card;
    }
}
