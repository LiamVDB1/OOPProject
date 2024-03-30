package be.ugent.objprog.ugentopoly;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
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

    //id naar Property, Tile en Street mappen
    private Map<String, String> idToProperty;
    private Map<String, Street> idToStreet;
    private Map<String, Tile> idToTile;

    //Settings van het bord bijhouden
    private int startBalance;
    private int startSalary;

    //Areas en Tiles bijhouden, met posities.
    private Area[] areas;
    private Tile[] tiles;

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

        idToProperty = new HashMap<>();
        idToStreet = new HashMap<>();
        idToTile = new HashMap<>();
        areas = new Area[8];
        tiles = new Tile[40];

        tilesShown = false;
    }

    public void setBalSal(int balance, int salary){
        startBalance = balance;
        startSalary = salary;
    }

    public void gridLabelFiller(Properties properties){
        propertyFill(properties);
        fillProperties(left, properties);
        fillProperties(right, properties);
        fillProperties(top, properties);
        fillProperties(bottom, properties);
    }
    private void fillProperties(GridPane grid, Properties properties){
        for (Node node : grid.getChildren()) {
            if (node instanceof Parent parent) {
                for (Node child : parent.getChildrenUnmodifiable()) {
                    if (child instanceof Label label && child.getId() != null && child.getId().startsWith("Text")){
                        label.setText(idToProperty.get("tile." + label.getId().substring(4)));
                    } else if (child instanceof Pane pane && pane.getId() != null && pane.getId().startsWith("Color")){
                        String id = "tile." + pane.getId().substring(5);
                        Area area = idToStreet.get(id).getArea();
                        pane.setStyle("-fx-background-color: " + area.getColor() + ";");
                    }
                }
            }
        }
    }
    private void propertyFill(Properties properties){
        for (String key : properties.stringPropertyNames()){
            if (key.startsWith("tile.")){
                idToProperty.put(key, properties.getProperty(key));
            }
        }
        tileFill();
    }

    private void tileFill(){
        for (int i = 0; i < tiles.length; i++){
            if (tiles[i] != null){
                tiles[i].setText(idToProperty.get(tiles[i].getId()));
            }
            idToTile.put(tiles[i].getId(), tiles[i]);
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
        for (int i = 0; i < children.size(); i++) {
            Element child = children.get(i);
            String type = child.getAttributeValue("type");

            TileFactory factory = factories.get(type);
            if (factory != null) {
                Tile tile = factory.createTile(child, areaMap);
                if (type.equals("STREET")){
                    idToStreet.put(child.getAttributeValue("id"), (Street) tile);
                }
                try {
                    int position = child.getAttribute("position").getIntValue();
                    this.tiles[position] = tile;
                } catch (DataConversionException e) {
                    System.err.println("Error in XML File, position is not Integer");
                }
            }
        }
    }

    public void showTile(String id){
        Tile tile = idToTile.get("tile." + id);
        if (tile != null){
            cardPane.getChildren().clear();
            cardPane.getChildren().add(tile.getCard());
        }
        swapPanes(true);
    }

    public void showBoard(){
        swapPanes(false);
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
