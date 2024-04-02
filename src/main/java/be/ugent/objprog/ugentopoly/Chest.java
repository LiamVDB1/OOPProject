package be.ugent.objprog.ugentopoly;

public class Chest extends Tile{
    public Chest(int position, String id){
        super(position, id);
    }

    @Override
    public TileMidCard getMidCard() {
        return new ChestMidCard(this);
    }
}
