package be.ugent.objprog.ugentopoly;

import java.util.ArrayList;
import java.util.List;

public class Area {
    private String id;
    private String color;

    public Area(String id, String color) {
        this.id = id;
        this.color = color;
    }

    public String getColor(){
        return color;
    }
}
