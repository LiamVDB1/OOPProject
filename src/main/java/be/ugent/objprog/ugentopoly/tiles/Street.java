package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.Area;
import be.ugent.objprog.ugentopoly.Board;
import be.ugent.objprog.ugentopoly.tileCards.StreetCard;
import be.ugent.objprog.ugentopoly.TileCard;
import be.ugent.objprog.ugentopoly.tileMidCards.StreetMidCard;
import be.ugent.objprog.ugentopoly.tileMidCards.TileMidCard;
import javafx.scene.layout.GridPane;

public class Street extends Tile {
    private int cost;
    private int rent;
    private Area area;

    public Street(int position, String id, int cost, Area area, int rent, GridPane Parent, Board bord){
        super(position, id, Parent, bord);
        this.cost = cost;
        this.area = area;
        this.rent = rent;
    }

    public Area getArea() {
        return area;
    }

    public String getColor(){
        return getArea().getColor();
    }

    public int getCost(){
        return cost;
    }

    public int getRent(){
        return rent;
    }

    @Override
    public TileMidCard getMidCard() {
        return new StreetMidCard(this);
    }

    @Override
    public TileCard makeCard() {
        TileCard card =  new StreetCard(this, Parent, gridPos, vertical, LT);
        this.card = card;
        return card;
    }
}