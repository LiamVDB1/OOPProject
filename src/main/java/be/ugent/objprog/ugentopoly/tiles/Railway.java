package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.layout.tileCards.RailwayCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.RailwayMidCard;
import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.Board;

public class Railway extends Tile{
    private int cost;
    private int rent;
    public Railway(int position, String id, int cost, int rent, Board bord){
        super(position, id, bord);
        this.cost = cost;
        this.rent = rent;
        Card card =  new RailwayCard(this, vertical, LT);
        this.card = card;
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
}
