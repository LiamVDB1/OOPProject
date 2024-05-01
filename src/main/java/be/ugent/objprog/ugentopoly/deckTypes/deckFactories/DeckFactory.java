package be.ugent.objprog.ugentopoly.deckTypes.deckFactories;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.deckTypes.DeckType;
import org.jdom2.Element;

public interface DeckFactory {
    DeckType createDeckType(BoardModel boardMode, Element element);
}
