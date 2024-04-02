package be.ugent.objprog.ugentopoly;

public abstract class Tile {
    protected int position;
    protected String id;
    protected String text;

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

    public void setText(String text){ this.text = text; }
    public String getText(){ return text;}

    public abstract TileMidCard getMidCard();

    //public abstract TileCard getCard();
}
