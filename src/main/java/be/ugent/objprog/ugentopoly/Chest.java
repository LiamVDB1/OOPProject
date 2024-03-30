package be.ugent.objprog.ugentopoly;

public class Chest extends Tile{
    public Chest(int position, String id){
        super(position, id);
    }

    @Override
    public TileCard getCard() {
        return new ChestCard(this);
    }
}
