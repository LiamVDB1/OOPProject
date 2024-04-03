package be.ugent.objprog.ugentopoly;

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
        return new RailwayCard(this, Parent, gridPos, vertical, LT);
    }
}
