package be.ugent.objprog.ugentopoly;

public class Jail extends Tile{
    public Jail(int position, String id){
        super(position, id);
    }

    @Override
    public TileCard getCard() {
        return new JailCard(this);
    }
}
