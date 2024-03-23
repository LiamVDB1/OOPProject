package be.ugent.objprog.ugentopoly;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import org.jdom2.Attribute;
import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.*;
import java.util.function.Supplier;

public class Board {
    //UI elementen
    private BorderPane board;
    private GridPane top;
    private GridPane left;
    private StackPane center;
    private GridPane right;
    private GridPane bottom;

    //id naar property mappen
    private Map<String, String> idToProperty;

    //Settings van het bord bijhouden
    private int startBalance;
    private int startSalary;

    //Areas en Tiles bijhouden, met posities.
    private Area[] areas;
    private Tile[] tiles;

    public Board(BorderPane board, GridPane top, GridPane left, StackPane center, GridPane right, GridPane bottom) {
        this.board = board;
        this.top = top;
        this.left = left;
        this.center = center;
        this.right = right;
        this.bottom = bottom;
        idToProperty = new HashMap<>();
        areas = new Area[8];
        tiles = new Tile[40];
    }

    public void setBalSal(int balance, int salary){
        startBalance = balance;
        startSalary = salary;
    }

    public void gridLabelFiller(Properties properties){
        mapFill(properties);
        fillProperties(left, properties);
        fillProperties(right, properties);
        fillProperties(top, properties);
        fillProperties(bottom, properties);
    }
    private void fillProperties(GridPane grid, Properties properties){
        for (Node node : grid.getChildren()){
            if (node instanceof Label label && node.getId() != null){
                label.setText(idToProperty.get("tile." + label.getId().substring(4)));
            } else if (node instanceof Parent parent){
                for (Node child: parent.getChildrenUnmodifiable()){
                    if (child instanceof Label label && child.getId() != null){
                        label.setText(idToProperty.get("tile." + label.getId().substring(4)));
                    }
                }
            }
        }
    }
    private void mapFill(Properties properties){
        for (String key : properties.stringPropertyNames()){
            if (key.startsWith("tile.")){
                idToProperty.put(key, properties.getProperty(key));
            }
        }
    }

    public void setAreas(Element areas){
        List<Element> children = areas.getChildren("area");
        for (int i = 0; i < children.size(); i ++){
            Element area = children.get(i);
            String color = area.getAttributeValue("color");
            int housePrice = Integer.parseInt(area.getAttributeValue("house"));
            Area newArea = new Area(i, color, housePrice);
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
        List<Element> children = streets.getChildren("tile");
        for (int i = 0; i < children.size(); i++) {
            Element child = children.get(i);
            String type = child.getAttributeValue("type");
            TileFactory factory = factories.get(type);
            if (factory != null) {
                Tile tile = factory.createTile(child);
                try {
                    int position = child.getAttribute("position").getIntValue();
                    this.tiles[position] = tile;
                } catch (DataConversionException e) {
                    System.out.println("Error in XML File, position is not Integer");
                }
            }
        }
    }
}
