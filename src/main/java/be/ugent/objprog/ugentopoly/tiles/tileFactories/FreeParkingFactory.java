package be.ugent.objprog.ugentopoly.tiles.tileFactories;

import be.ugent.objprog.ugentopoly.Area;
import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.tiles.FreeParking;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.Map;

public class FreeParkingFactory implements TileFactory{
    @Override
    public Tile createTile(Element element, Map<String, Area> areaMap, BoardModel bord){
        try {
            int position = element.getAttribute("position").getIntValue();
            return new FreeParking(position, element.getAttributeValue("id"), bord);
        } catch(DataConversionException e){
            System.out.println("Error in XML File, position not integer");
            return null;
        }
    }
}
