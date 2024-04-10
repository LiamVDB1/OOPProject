package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.Area;
import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileCards.StreetCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.StreetMidCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;

public class Street extends Tile {
    private int cost;
    private int rent;
    private Area area;

    public Street(int position, String id, int cost, Area area, int rent, BoardModel bord){
        super(position, id, bord);
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
    public void initializeCards() {
        this.card = new StreetCard(this, vertical, LT);
        this.midCard = new StreetMidCard(this);
    }
}
