package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.factories.*;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.jdom2.Element;

import java.util.*;

public class Board {
    //UI elementen
    private final GridPane left;
    /*
    private final BorderPane board;
    private final GridPane top;
    private final GridPane left;
    private final StackPane center;
    private final GridPane right;
    private final GridPane bottom;
    */
    private final BoardView boardView;

    private final AnchorPane cardPane;

    private final AnchorPane boardShow;
    private final AnchorPane tileShow;

    //Settings van het bord bijhouden
    private int startBalance;
    private int startSalary;

    //Areas en Tiles bijhouden, met posities.
    private Area[] areas;
    private Tile[] tiles;

    //Vorige geklikte tile bijhouden
    private Tile prevTile;

    //Map voor de positie van de tile naar de parent gridpane
    private final Map<Integer, GridPane> posToParent;

    //Spelers
    private List<Speler> spelers = new ArrayList<>();

    public Board(BorderPane board, GridPane top, GridPane left, StackPane center, GridPane right, GridPane bottom, AnchorPane cardPane, AnchorPane boardShow, AnchorPane tileShow){
        // this.board = board; this.top = top; this.left = left; this.center = center; this.right = right; this.bottom = bottom;
        this.left = left;

        boardView = new BoardView(board, top, left, center, right, bottom, cardPane, boardShow, tileShow);

        this.cardPane = cardPane; this.boardShow = boardShow; this.tileShow = tileShow;

        this.prevTile = null;

        areas = new Area[8]; tiles = new Tile[40];

        posToParent = new HashMap<>();
        for (int i = 0; i < 40; i++){
            if (i == 0){ posToParent.put(i, bottom);
            } else if (i < 10){ posToParent.put(i, left);
            } else if (i < 21){ posToParent.put(i, top);
            } else if (i < 30){ posToParent.put(i, right);
            } else { posToParent.put(i, bottom);
            }
        }
    }

    public GridPane getLeft() { return left; }

    public void setBalanceAndSalary(int balance, int salary){
        startBalance = balance; startSalary = salary;
    }

    public int getStartBalance() { return startBalance; }

    public int getStartSalary() { return startSalary; }

    public void propertySetup(Properties properties){
        for (Tile tile : tiles){ tile.setText(properties.getProperty(tile.getId())); }
    }

    public void setAreas(Element areas){
        List<Element> children = areas.getChildren("area");
        for (int i = 0; i < children.size(); i ++){
            Element area = children.get(i);

            Area newArea = new Area(area.getAttributeValue("id"), area.getAttributeValue("color"));
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
                Tile tile = factory.createTile(child, areaMap, this);
                this.tiles[tile.getPosition()] = tile;
            }
        }
    }

    public void setGridPositions(){
        // De waarden 10, 21 en 30 zijn voor de top, left, right en bottom. De speciale waarden van gridPos is omdat de tiles in een andere volgorde staan.
        // Het bord is altijd in 40 tiles, dus heb ik deze waarden gehardcode.
        for (int i = 0; i < tiles.length; i ++){
            int gridPos;
            if (i == 0){ gridPos = 0;
            } else if (i < 10){ gridPos = 9 - i;
            } else if (i < 21){ gridPos = i - 10;
            } else if (i < 30){ gridPos = i - 21;
            } else { gridPos = 10 - (i - 30); }
            tiles[i].setGridPos(gridPos);
        }
        makeCards();
    }

    public void makeCards(){
        for (Tile tile : tiles){
            Card card = tile.getCard();
            GridPane parent = posToParent.get(tile.getPosition());
            //boardView.placeCard(card, parent, tile.getGridPos1(), tile.getGridPos2());
            parent.add(card, tile.getGridPos1(), tile.getGridPos2());
        }
    }

    public void showTile(Tile tile){
        if (prevTile != null){
            prevTile.getCard().getStyleClass().remove("selected");
        }
        if (tile != null){
            if (tile == prevTile){
                showBoard();
            } else {
                cardPane.getChildren().clear();
                cardPane.getChildren().add(tile.getMidCard());

                if (! boardShow.getStyleClass().contains("invisible")){
                    boardShow.getStyleClass().add("invisible");
                    tileShow.getStyleClass().remove("invisible");
                }

                tile.getCard().getStyleClass().add("selected");
                prevTile = tile;
            }
        }
    }

    public void showBoard(){
        if (prevTile != null){
            prevTile.getCard().getStyleClass().remove("selected");
        }

        if (boardShow.getStyleClass().contains("invisible")){
            tileShow.getStyleClass().add("invisible");
            boardShow.getStyleClass().remove("invisible");
        }

        prevTile = null;
    }

    public void addSpeler(Speler speler){
        spelers.add(speler);
    }

    public void startSpel(){
        Stage stage = (Stage) cardPane.getScene().getWindow();
        stage.show();
    }
}
