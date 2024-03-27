package be.ugent.objprog.ugentopoly;

import org.jdom2.Element;

import java.util.Map;

public interface TileFactory {
    public Tile createTile(Element element, Map<String, Area> areaMap);
}
