package be.ugent.objprog.ugentopoly.deckTypes.deckFactories;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.deckTypes.PlayersMoneyType;
import be.ugent.objprog.ugentopoly.deckTypes.DeckType;
import org.jdom2.Element;

import java.util.List;

public class PlayersMoneyTypeFactory implements DeckFactory{
    @Override
    public DeckType createDeckType(BoardModel boardModel, Element element, List<DeckType> deck) {
        String id = element.getAttributeValue("id");
        int amount = Integer.parseInt(element.getAttributeValue("amount"));
        return new PlayersMoneyType(boardModel, id, amount);
    }
}
