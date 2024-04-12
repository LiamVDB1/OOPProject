package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.Area;
import be.ugent.objprog.ugentopoly.tiles.Chest;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import be.ugent.objprog.ugentopoly.Board;
import javafx.scene.layout.GridPane;
import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.Map;

public class ChestFactory implements TileFactory{
    @Override
    public Tile createTile(Element element, Map<String, Area> areaMap, Board bord){
        try {
            int position = element.getAttribute("position").getIntValue();
            return new Chest(position, element.getAttributeValue("id"), bord);
        } catch(DataConversionException e){
            System.out.println("Error in XML File, position not integer");
            return null;
        }
    }
}
