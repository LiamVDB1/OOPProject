package be.ugent.objprog.ugentopoly;

public class Utility extends Tile{
    int cost;
    public Utility(int position, String id, int cost){
        super(position, id);
        this.cost = cost;
    }

    @Override
    public TileMidCard getMidCard() {
        return new UtilityMidCard(this);
    }

    public int getCost(){
        return cost;
    }

    public int getNr(){
        return Integer.parseInt(id.substring(id.length() - 1));
    }
}
