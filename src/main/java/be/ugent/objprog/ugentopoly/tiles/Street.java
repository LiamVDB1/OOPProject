package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.Area;
import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.layout.tileCards.StreetCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.StreetMidCard;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Street extends Tile {
    private int cost;
    private int rent;
    private Area area;

    public Street(int position, String id, int cost, Area area, int rent, BoardModel bord){
        super(position, id, bord);
        this.cost = cost;
        this.area = area;
        this.rent = rent;
        this.graphic = rectangleCreator();
    }

    public Area getArea() {
        return area;
    }

    public Color getColor(){
        return Color.valueOf(getArea().getColor());
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
    public Rectangle rectangleCreator() {
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(getColor());
        return rectangle;
    }
}
