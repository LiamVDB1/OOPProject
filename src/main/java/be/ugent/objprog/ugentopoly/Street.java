package be.ugent.objprog.ugentopoly;

public class Street extends Tile {
    private int cost;
    private int[] rents;
    private Area area;

    public Street(int position, String id, int cost, int[] rents){
        super(position, id);
        this.cost = cost;
        this.rents = rents;
    }
}
