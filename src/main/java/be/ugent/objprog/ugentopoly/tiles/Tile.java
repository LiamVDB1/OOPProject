package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.TileCard;
import be.ugent.objprog.ugentopoly.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.Board;
import javafx.scene.layout.GridPane;

public abstract class Tile {
    protected int position;
    protected String id;
    protected String text;

    protected boolean vertical;
    protected boolean LT;
    protected int gridPos;

    protected Board bord;

    protected TileCard card;

    GridPane Parent;

    public Tile(int position, String id, GridPane Parent, Board bord){
        this.position = position;
        this.id = id;
        this.Parent = Parent;
        this.bord = bord;
        vertical = Parent.getId().equals("left") || Parent.getId().equals("right");
        LT = Parent.getId().equals("left") || Parent.getId().equals("top");
    }

    public int getPosition() {
        return position;
    }

    public String getId() {
        return id;
    }

    public void setText(String text){ this.text = text; }
    public String getText(){ return text;}

    public void setGridPos(int gridPos){
        this.gridPos = gridPos;
    }

    public abstract TileMidCard getMidCard();

    public abstract TileCard makeCard();

    public TileCard getCard(){
        return card;
    }

    public Board getBord(){
        return bord;
    }
}
