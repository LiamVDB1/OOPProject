package be.ugent.objprog.ugentopoly.deckTypes.deckFactories;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.deckTypes.DeckType;
import be.ugent.objprog.ugentopoly.deckTypes.MoveRelType;
import org.jdom2.Element;

import java.util.List;

public class MoveRelTypeFactory implements DeckFactory{
    @Override
    public DeckType createDeckType(BoardModel boardModel, Element element, List<DeckType> deck) {
        String id = element.getAttributeValue("id");
        int rel = Integer.parseInt(element.getAttributeValue("relative"));
        return new MoveRelType(boardModel, id, rel);
    }
}
