package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;
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

    protected Card card;

    protected int gridPos1;
    protected int gridPos2;

    public Tile(int position, String id, Board bord){
        this.position = position;
        this.id = id;
        this.bord = bord;
        vertical = (position != 0 && position < 10) || (position > 20 && position < 30);
        LT = position != 0 && position < 21;
        //vertical = Parent.getId().equals("left") || Parent.getId().equals("right");
        //LT = Parent.getId().equals("left") || Parent.getId().equals("top");
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
        if (vertical){
            gridPos1 = 0;
            gridPos2 = gridPos;
        } else {
            gridPos1 = gridPos;
            gridPos2 = 0;
        }
    }

    public int getGridPos1(){
        return gridPos1;
    }
    public int getGridPos2(){
        return gridPos2;
    }

    public abstract TileMidCard getMidCard();

    public Card getCard(){
        return card;
    }

    public Board getBord(){
        return bord;
    }
}
