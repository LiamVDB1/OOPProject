package be.ugent.objprog.ugentopoly.deckTypes.deckFactories;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.deckTypes.MoneyType;
import be.ugent.objprog.ugentopoly.deckTypes.DeckType;
import org.jdom2.Element;

public class MoneyTypeFactory implements  DeckFactory{
    @Override
    public DeckType createDeckType(BoardModel boardModel, Element element) {
        String id = element.getAttributeValue("id");
        int amount = Integer.parseInt(element.getAttributeValue("amount"));
        return new MoneyType(boardModel, id, amount);
    }
}
