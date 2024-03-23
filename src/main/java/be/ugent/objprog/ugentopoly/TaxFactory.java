package be.ugent.objprog.ugentopoly;

import org.jdom2.DataConversionException;
import org.jdom2.Element;

public class TaxFactory implements TileFactory{
    @Override
    public Tile createTile(Element element) {
        try {
            int position = element.getAttribute("position").getIntValue();
            int amount = element.getAttribute("amount").getIntValue();
            return new Tax(position, element.getAttributeValue("id"), amount);
        } catch(DataConversionException e){
            System.out.println("Error in XML File, Convertion to Integer");
            return null;
        }
    }
}