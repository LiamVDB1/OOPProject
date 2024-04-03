package be.ugent.objprog.ugentopoly;

import javafx.scene.layout.GridPane;
import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.Map;

public class ChanceFactory implements TileFactory{
    @Override
    public Tile createTile(Element element, Map<String, Area> areaMap, Map<Integer, GridPane> posToParent, Board bord) {
        try {
            int position = element.getAttribute("position").getIntValue();
            GridPane parent = posToParent.get(position);
            return new Chance(position, element.getAttributeValue("id"), parent, bord);
        } catch(DataConversionException e){
            System.out.println("Error in XML File, position not integer");
            return null;
        }
    }
}
