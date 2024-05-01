package be.ugent.objprog.ugentopoly.tiles.tileFactories;

import be.ugent.objprog.ugentopoly.Area;
import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.tiles.Railway;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.Map;

public class RailwayFactory implements TileFactory{
    @Override
    public Tile createTile(Element element, Map<String, Area> areaMap, BoardModel bord){
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
