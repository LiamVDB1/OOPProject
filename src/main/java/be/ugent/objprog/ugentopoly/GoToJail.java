package be.ugent.objprog.ugentopoly;

public class GoToJail extends Tile{
    public GoToJail(int position, String id){
        super(position, id);
    }

    @Override
    public TileCard getCard() {
        return new GoToJailCard(this);
    }
}
