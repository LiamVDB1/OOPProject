package be.ugent.objprog.ugentopoly.deckTypes.deckFactories;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.deckTypes.JailType;
import be.ugent.objprog.ugentopoly.deckTypes.DeckType;
import org.jdom2.Element;

public class JailTypeFactory implements DeckFactory{
    @Override
    public DeckType createDeckType(BoardModel boardMode, Element element) {
        String id = element.getAttributeValue("id");
        return new JailType(boardMode, id);
    }
}
