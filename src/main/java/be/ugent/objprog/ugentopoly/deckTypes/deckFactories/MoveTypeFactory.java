package be.ugent.objprog.ugentopoly.deckTypes.deckFactories;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.deckTypes.MoveType;
import be.ugent.objprog.ugentopoly.deckTypes.DeckType;
import org.jdom2.Element;

public class MoveTypeFactory implements  DeckFactory{
    @Override
    public DeckType createDeckType(BoardModel boardModel, Element element) {
        String id = element.getAttributeValue("id");
        boolean collect = Boolean.parseBoolean(element.getAttributeValue("collect"));
        int position = Integer.parseInt(element.getAttributeValue("position"));
        return new MoveType(boardModel, id, collect, position);
    }
}
