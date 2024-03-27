package be.ugent.objprog.ugentopoly;

import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.Map;

public class StartFactory implements TileFactory{
    @Override
    public Tile createTile(Element element, Map<String, Area> areaMap){
        try {
            int position = element.getAttribute("position").getIntValue();
            return new Start(position, element.getAttributeValue("id"));
        } catch(DataConversionException e){
            System.out.println("Error in XML File, position not integer");
            return null;
        }
    }
}
