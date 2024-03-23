package be.ugent.objprog.ugentopoly;

import org.jdom2.DataConversionException;
import org.jdom2.Element;

public class GoToJailFactory implements TileFactory{
    @Override
    public Tile createTile(Element element) {
        try {
            int position = element.getAttribute("position").getIntValue();
            return new GoToJail(position, element.getAttributeValue("id"));
        } catch(DataConversionException e){
            System.out.println("Error in XML File, position not integer");
            return null;
        }
    }
}
