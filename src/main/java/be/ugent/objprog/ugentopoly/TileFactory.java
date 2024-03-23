package be.ugent.objprog.ugentopoly;

import org.jdom2.Element;

public interface TileFactory {
    public Tile createTile(Element element);
}
