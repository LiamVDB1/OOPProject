package be.ugent.objprog.ugentopoly;

public class Utility extends Tile{
    int cost;
    public Utility(int position, String id, int cost){
        super(position, id);
        this.cost = cost;
    }

    @Override
    public TileCard getCard() {
        return new UtilityCard(this);
    }

    public int getCost(){
        return cost;
    }
}
