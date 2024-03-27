package be.ugent.objprog.ugentopoly;

public class Railway extends Tile{
    private int cost;
    private int rent;
    public Railway(int position, String id, int cost, int rent){
        super(position, id);
        this.cost = cost;
        this.rent = rent;
    }


}
