package be.ugent.objprog.ugentopoly;

import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.Map;

public class StreetFactory implements TileFactory{
    @Override
    public Tile createTile(Element element, Map<String, Area> areaMap){
        try {
            int position = element.getAttribute("position").getIntValue();
            int cost = element.getAttribute("cost").getIntValue();
            int rent = element.getAttribute("rent0").getIntValue();

            String areaString = element.getAttributeValue("area");
            Area area = areaMap.get(areaString);

            return new Street(position, element.getAttributeValue("id"), cost, area,rent);
        } catch(DataConversionException e){
            System.out.println("Error in XML File, Convertion to Integer");
            return null;
        }
    }
}
