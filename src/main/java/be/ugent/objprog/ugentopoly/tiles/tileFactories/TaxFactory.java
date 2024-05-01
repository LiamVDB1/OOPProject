package be.ugent.objprog.ugentopoly.tiles.tileFactories;

import be.ugent.objprog.ugentopoly.Area;
import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.tiles.Tax;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.Map;

public class TaxFactory implements TileFactory{
    @Override
    public Tile createTile(Element element, Map<String, Area> areaMap, BoardModel bord){
        try {
            int position = element.getAttribute("position").getIntValue();
            int amount = element.getAttribute("amount").getIntValue();
            return new Tax(position, element.getAttributeValue("id"), amount, bord);
        } catch(DataConversionException e){
            System.out.println("Error in XML File, Convertion to Integer");
            return null;
        }
    }
}
