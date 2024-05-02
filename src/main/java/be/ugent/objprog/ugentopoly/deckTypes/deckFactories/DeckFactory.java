package be.ugent.objprog.ugentopoly.deckTypes.deckFactories;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.deckTypes.DeckType;
import org.jdom2.Element;

import java.util.List;

public interface DeckFactory {
    DeckType createDeckType(BoardModel boardMode, Element element, List<DeckType> deck);
}
