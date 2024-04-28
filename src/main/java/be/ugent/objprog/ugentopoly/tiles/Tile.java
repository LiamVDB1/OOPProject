package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.layout.tileCards.TileCards;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.TileMidCard;
import be.ugent.objprog.ugentopoly.BoardModel;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.InputStream;

public abstract class Tile {
    protected int position;
    protected String id;
    protected String text;
    protected Image image; //In de initializatie van elke klasse gezet
    protected Node graphic;

    protected boolean vertical;
    protected boolean LT;
    protected int gridPos;

    protected BoardModel bord;

    protected Card card;

    protected TileMidCard midCard;

    protected int gridPos1;
    protected int gridPos2;

    public Tile(int position, String id, BoardModel bord){
        this.position = position;
        this.id = id;
        this.bord = bord;
        vertical = (position != 0 && position < 10) || (position > 20 && position < 30);
        LT = position != 0 && position < 21;
    }

    public int getPosition() {
        return position;
    }

    public String getId() {
        return id;
    }

    public void setText(String text){ this.text = text; }
    public String getText(){ return text;}

    public void imageCreate(String fileName){
        try (InputStream input = this.getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/" + fileName)){
            if (input == null) {throw new NullPointerException();}
            Image image = new Image(input);
            this.image = image;

            ImageView imageView = new ImageView(image);
            imageView.setPreserveRatio(true);
            this.graphic = imageView;
        } catch (IOException e) { System.err.println("Error " + fileName + " not in assets folder");
        } catch (NullPointerException e){ System.err.println("Error " + fileName + " not found in assets folder");
        }
    }

    public Image getImage(){ return image; }
    public Node getGraphic(){ return this.graphic; }

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

    public abstract void initializeCards();

    public Card getCard(){ return card; }

    public TileCards getTileCard(){ return (TileCards) card;}

    public TileMidCard getMidCard(){ return midCard;}

    public BoardModel getBord(){
        return bord;
    }

}
