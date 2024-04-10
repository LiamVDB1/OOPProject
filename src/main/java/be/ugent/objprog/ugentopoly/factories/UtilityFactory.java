package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.Area;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import be.ugent.objprog.ugentopoly.tiles.Utility;
import be.ugent.objprog.ugentopoly.BoardModel;
import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.Map;

public class UtilityFactory implements TileFactory{
    @Override
    public Tile createTile(Element element, Map<String, Area> areaMap, BoardModel bord){
        try {
            int position = element.getAttribute("position").getIntValue();
            int cost = element.getAttribute("cost").getIntValue();
            return new Utility(position, element.getAttributeValue("id"), cost, bord);
        } catch(DataConversionException e){
            System.out.println("Error in XML File, Convertion to Integer");
            return null;
        }
    }
}
