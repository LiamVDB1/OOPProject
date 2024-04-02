package be.ugent.objprog.ugentopoly;

public class GoToJail extends Tile{
    public GoToJail(int position, String id){
        super(position, id);
    }

    @Override
    public TileMidCard getMidCard() {
        return new GoToJailMidCard(this);
    }
}
