package be.ugent.objprog.ugentopoly.deckTypes;

import be.ugent.objprog.ugentopoly.BoardModel;
import java.util.List;

public class JailType extends DeckType {
    private List<DeckType> deck;
    public JailType(BoardModel boardModel, String id, List<DeckType> deck) {
        super(boardModel, id);
        this.deck = deck;
    }

    @Override
    public void action() {
        boardModel.jailDeckCard(this, deck);
    }
}
