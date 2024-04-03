package be.ugent.objprog.ugentopoly;

import javafx.scene.layout.GridPane;
import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.Map;

public class RailwayFactory implements TileFactory{
    @Override
    public Tile createTile(Element element, Map<String, Area> areaMap, Map<Integer, GridPane> posToParent, Board bord){
        try {
            int position = element.getAttribute("position").getIntValue();
            int cost =  element.getAttribute("cost").getIntValue();
            int rent = element.getAttribute("rent").getIntValue();
            GridPane Parent = posToParent.get(position);
            return new Railway(position, element.getAttributeValue("id"), cost, rent, Parent, bord);
        } catch(DataConversionException e){
            System.out.println("Error in XML File, Convertion to Integer");
            return null;
        }
    }
}
