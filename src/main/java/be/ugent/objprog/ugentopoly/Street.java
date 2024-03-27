package be.ugent.objprog.ugentopoly;

public class Street extends Tile {
    private int cost;
    private int rent;
    private Area area;

    public Street(int position, String id, int cost,Area area,  int rent){
        super(position, id);
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
}
