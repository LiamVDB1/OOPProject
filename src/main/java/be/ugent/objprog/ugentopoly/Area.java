package be.ugent.objprog.ugentopoly;

import java.util.ArrayList;
import java.util.List;

public class Area {
    private int pos;
    private String color;
    private List<Street> streets;
    private int housePrice;

    public Area(int pos, String color, int housePrice) {
        this.pos = pos;
        this.color = color;
        this.housePrice = housePrice;
        streets = new ArrayList<>();
    }

    public void addStreet(Street street) {
        streets.add(street);
    }
    public List<Street> getStreets() {
        return null;
    }

    public int getHousePrice() {
        return 0;
    }

}
