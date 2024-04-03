package be.ugent.objprog.ugentopoly;

import javafx.scene.layout.*;
import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.*;

public class Board {
    //UI elementen
    private BorderPane board;
    private GridPane top;
    private GridPane left;
    private StackPane center;
    private GridPane right;
    private GridPane bottom;

    private AnchorPane cardPane;

    private AnchorPane boardShow;
    private AnchorPane tileShow;
    private boolean tilesShown;

    //Settings van het bord bijhouden
    private int startBalance;
    private int startSalary;

    //Areas en Tiles bijhouden, met posities.
    private Area[] areas;
    private Tile[] tiles;

    private Tile prevTile;

    private Map<Integer, GridPane> posToParent;

    public Board(BorderPane board, GridPane top, GridPane left, StackPane center, GridPane right, GridPane bottom, AnchorPane cardPane, AnchorPane boardShow, AnchorPane tileShow){
        this.board = board;
        this.top = top;
        this.left = left;
        this.center = center;
        this.right = right;
        this.bottom = bottom;

        this.cardPane = cardPane;
        this.boardShow = boardShow;
        this.tileShow = tileShow;

        this.prevTile = null;

        areas = new Area[8];
        tiles = new Tile[40];

        tilesShown = false;

        posToParent = new HashMap<>();
        for (int i = 0; i < 40; i++){
            if (i == 0){
                posToParent.put(i, bottom);
            } else if (i < 10){
                posToParent.put(i, left);
            } else if (i < 21){
                posToParent.put(i, top);
            } else if (i < 30){
                posToParent.put(i, right);
            } else {
                posToParent.put(i, bottom);
            }
        }
    }

    public void setBalSal(int balance, int salary){
        startBalance = balance;
        startSalary = salary;
    }

    public void propertySetup(Properties properties){
        for (Tile tile : tiles){
            tile.setText(properties.getProperty(tile.getId()));
        }
    }

    public void setAreas(Element areas){
        List<Element> children = areas.getChildren("area");
        for (int i = 0; i < children.size(); i ++){
            Element area = children.get(i);
            String color = area.getAttributeValue("color");
            String id = area.getAttributeValue("id");

            Area newArea = new Area(id, color);
            this.areas[i] = newArea;
        }
    }
    public void setTiles(Element streets) {
        Map<String, TileFactory> factories = Map.of(
                "CHANCE", new ChanceFactory(),
                "CHEST", new ChestFactory(),
                "FREE_PARKING", new FreeParkingFactory(),
                "GO_TO_JAIL", new GoToJailFactory(),
                "JAIL", new JailFactory(),
                "RAILWAY", new RailwayFactory(),
                "START", new StartFactory(),
                "STREET", new StreetFactory(),
                "TAX", new TaxFactory(),
                "UTILITY", new UtilityFactory()
        );
        Map<String, Area> areaMap = Map.of(
                "area1", areas[0],
                "area2", areas[1],
                "area3", areas[2],
                "area4", areas[3],
                "area5", areas[4],
                "area6", areas[5],
                "area7", areas[6],
                "area8", areas[7]
        );
        List<Element> children = streets.getChildren("tile");
        for (Element child : children) {
            String type = child.getAttributeValue("type");

            TileFactory factory = factories.get(type);
            if (factory != null) {
                Tile tile = factory.createTile(child, areaMap, posToParent, this);
                try {
                    int position = child.getAttribute("position").getIntValue();
                    this.tiles[position] = tile;
                } catch (DataConversionException e) {
                    System.err.println("Error in XML File, position is not Integer");
                }
            }
        }
    }

    public void boardFiller(){
        tiles[0].setGridPos(0);
        tiles[0].makeCard();
        for (int i = 0; i < 9; i ++){
            tiles[i + 1].setGridPos(8 - i);
            tiles[i + 1].makeCard();
        }
        for (int i = 0; i < 11; i ++){
            tiles[i + 10].setGridPos(i);
            tiles[i + 10].makeCard();
        }
        for (int i = 8; i >= 0; i --){
            tiles[i + 21].setGridPos(i);
            tiles[i + 21].makeCard();
        }
        for (int i =0; i < 10; i ++){
            tiles[i + 30].setGridPos(10 - i);
            tiles[i + 30].makeCard();
        }
    }

    public void showTile(Tile tile){
        if (tile != null){
            if (tile == prevTile){
                showBoard();
                prevTile = null;
            } else {
                cardPane.getChildren().clear();
                cardPane.getChildren().add(tile.getMidCard());
                swapPanes(true);
                prevTile = tile;
            }
        }
    }

    public void showBoard(){
        swapPanes(false);
        prevTile = null;
    }

    public void swapPanes(boolean to_tile){
        if (tilesShown){
            if (! to_tile){
                tileShow.getStyleClass().add("invisble");
                boardShow.getStyleClass().remove("invisble");
                tilesShown = false;
            }
        } else {
            if (to_tile) {
                tileShow.getStyleClass().remove("invisble");
                boardShow.getStyleClass().add("invisble");
                tilesShown = true;
            }
        }
    }
}
