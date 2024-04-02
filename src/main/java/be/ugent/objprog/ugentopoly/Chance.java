package be.ugent.objprog.ugentopoly;

public class Chance extends Tile{
    public Chance(int position, String id){
        super(position, id);
    }

    @Override
    public TileMidCard getMidCard() {
        return new ChanceMidCard(this);
    }
}
