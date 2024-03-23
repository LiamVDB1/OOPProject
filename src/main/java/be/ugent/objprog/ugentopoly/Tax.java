package be.ugent.objprog.ugentopoly;

public class Tax extends Tile{
    int amount;
    public Tax(int position, String id, int amount){
        super(position, id);
        this.amount = amount;
    }
}
