package be.ugent.objprog.ugentopoly.tiles.tileFactories;

import be.ugent.objprog.ugentopoly.Area;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import be.ugent.objprog.ugentopoly.BoardModel;
import org.jdom2.Element;

import java.util.Map;

public interface TileFactory {
    Tile createTile(Element element, Map<String, Area> areaMap, BoardModel bord);
}
