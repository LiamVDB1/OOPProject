package be.ugent.objprog.ugentopoly;

public abstract class Tile {
    protected int position;
    protected String id;

    public Tile(int position, String id){
        this.position = position;
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public String getId() {
        return id;
    }
}
