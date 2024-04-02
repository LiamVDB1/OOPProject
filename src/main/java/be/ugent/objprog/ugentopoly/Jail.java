package be.ugent.objprog.ugentopoly;

public class Jail extends Tile{
    public Jail(int position, String id){
        super(position, id);
    }

    @Override
    public TileMidCard getMidCard() {
        return new JailMidCard(this);
    }
}
