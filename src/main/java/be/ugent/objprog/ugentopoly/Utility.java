package be.ugent.objprog.ugentopoly;

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
        return new UtilityCard(this, Parent, gridPos, vertical, LT);
    }
}
