package be.ugent.objprog.ugentopoly;

public class Chance extends Tile{
    public Chance(int position, String id){
        super(position, id);
    }

    @Override
    public TileCard getCard() {
        return new ChanceCard(this);
    }
}
