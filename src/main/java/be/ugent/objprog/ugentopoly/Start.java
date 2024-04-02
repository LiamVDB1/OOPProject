package be.ugent.objprog.ugentopoly;

public class Start extends Tile {
    public Start(int position, String id) {
        super(position, id);
    }

    @Override
    public TileMidCard getMidCard() {
        return new StartMidCard(this);
    }
}
