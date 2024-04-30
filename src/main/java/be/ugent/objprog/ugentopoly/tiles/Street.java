package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.Area;
import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.Speler;
import be.ugent.objprog.ugentopoly.layout.tileCards.StreetCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.StreetMidCard;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Street extends Eigendom {
    private Area area;

    public Street(int position, String id, int cost, Area area, int huur, BoardModel bord){
        super(position, id, bord, cost, huur);
        this.area = area;
        area.addStreet(this);
        this.graphic = rectangleCreator(20, 20);
    }

    public Area getArea() {
        return area;
    }

    public Color getColor(){
        return Color.valueOf(getArea().getColor());
    }

    @Override
    public void initializeCards() {
        this.card = new StreetCard(this, vertical, LT);
        this.midCard = new StreetMidCard(this);
    }
    public Rectangle rectangleCreator(Integer height, Integer width) {
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(getColor());
        if (height != null) {
            rectangle.setHeight(height);
        }
        if (width != null){
            rectangle.setWidth(width);
        }
        return rectangle;
    }
    @Override
    public void setEigenaar(Speler speler){
        super.setEigenaar(speler);
        if (area.getStreets().stream().allMatch(street -> street.getEigenaar() == speler)){
            area.getStreets().forEach(street -> street.setHuur(street.getBasisHuur()*2));
        }
    }
}
