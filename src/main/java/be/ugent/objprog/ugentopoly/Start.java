package be.ugent.objprog.ugentopoly;

public class Start extends Tile {
    public Start(int position, String id) {
        super(position, id);
    }

    @Override
    public TileCard getCard() {
        return new StartCard(this);
    }
}
