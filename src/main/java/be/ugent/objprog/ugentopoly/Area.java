package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.tiles.Street;

import java.util.ArrayList;
import java.util.List;

public class Area {
    private String id;
    private String color;
    private List<Street> streets;

    public Area(String id, String color) {
        this.id = id;
        this.color = color;
        this.streets = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void addStreet(Street street) {
        streets.add(street);
    }
}
