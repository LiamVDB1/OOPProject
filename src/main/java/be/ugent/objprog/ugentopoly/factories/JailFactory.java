package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.Area;
import be.ugent.objprog.ugentopoly.tiles.Jail;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import be.ugent.objprog.ugentopoly.Board;
import javafx.scene.layout.GridPane;
import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.Map;

public class JailFactory implements TileFactory{
    @Override
    public Tile createTile(Element element, Map<String, Area> areaMap, Map<Integer, GridPane> posToParent, Board bord){
        try {
            int position = element.getAttribute("position").getIntValue();
            GridPane Parent = posToParent.get(position);
            return new Jail(position, element.getAttributeValue("id"), Parent, bord);
        } catch(DataConversionException e){
            System.out.println("Error in XML File, position not integer");
            return null;
        }
    }
}