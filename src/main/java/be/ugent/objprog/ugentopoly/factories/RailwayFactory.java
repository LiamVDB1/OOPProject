package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.Area;
import be.ugent.objprog.ugentopoly.tiles.Railway;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import be.ugent.objprog.ugentopoly.Board;
import javafx.scene.layout.GridPane;
import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.Map;

public class RailwayFactory implements TileFactory{
    @Override
    public Tile createTile(Element element, Map<String, Area> areaMap, Board bord){
        try {
            int position = element.getAttribute("position").getIntValue();
            int cost =  element.getAttribute("cost").getIntValue();
            int rent = element.getAttribute("rent").getIntValue();
            return new Railway(position, element.getAttributeValue("id"), cost, rent, bord);
        } catch(DataConversionException e){
            System.out.println("Error in XML File, Convertion to Integer");
            return null;
        }
    }
}
