package be.ugent.objprog.ugentopoly;

import org.jdom2.DataConversionException;
import org.jdom2.Element;

public class StreetFactory implements TileFactory{
    @Override
    public Tile createTile(Element element) {
        try {
            int position = element.getAttribute("position").getIntValue();
            int cost = element.getAttribute("cost").getIntValue();

            //Alle attributen die starten met "rent" in een Array zetten.
            int[] rents = element.getAttributes().stream().filter(a -> a.getName().startsWith("rent")).mapToInt(a -> {
                try {
                    return a.getIntValue();
                } catch (DataConversionException e) {
                    System.out.println("Error in XML File, Convertion to Integer");
                    return 0;
                }
            }).toArray();

            return new Street(position, element.getAttributeValue("id"), cost, rents);
        } catch(DataConversionException e){
            System.out.println("Error in XML File, Convertion to Integer");
            return null;
        }
    }
}
