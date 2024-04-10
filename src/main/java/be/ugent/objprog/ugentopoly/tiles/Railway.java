package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.tileCards.RailwayCard;
import be.ugent.objprog.ugentopoly.tileMidCards.RailwayMidCard;
import be.ugent.objprog.ugentopoly.TileCard;
import be.ugent.objprog.ugentopoly.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.Board;
import javafx.scene.layout.GridPane;

public class Railway extends Tile{
    private int cost;
    private int rent;
    public Railway(int position, String id, int cost, int rent, GridPane Parent, Board bord){
        super(position, id, Parent, bord);
        this.cost = cost;
        this.rent = rent;
    }

    public int getCost(){
        return cost;
    }

    public int getRent(){
        return rent;
    }

    @Override
    public TileMidCard getMidCard() {
        return new RailwayMidCard(this);
    }

    @Override
    public TileCard makeCard() {
        TileCard card =  new RailwayCard(this, Parent, gridPos, vertical, LT);
        this.card = card;
        return card;
    }
}
