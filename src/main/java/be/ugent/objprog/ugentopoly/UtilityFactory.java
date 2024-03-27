package be.ugent.objprog.ugentopoly;

import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.Map;

public class UtilityFactory implements TileFactory{
    @Override
    public Tile createTile(Element element, Map<String, Area> areaMap){
        try {
            int position = element.getAttribute("position").getIntValue();
            int cost = element.getAttribute("cost").getIntValue();
            return new Utility(position, element.getAttributeValue("id"), cost);
        } catch(DataConversionException e){
            System.out.println("Error in XML File, Convertion to Integer");
            return null;
        }
    }
}
