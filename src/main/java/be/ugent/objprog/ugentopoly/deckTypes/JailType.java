package be.ugent.objprog.ugentopoly.deckTypes;

import be.ugent.objprog.ugentopoly.BoardModel;

public class JailType extends DeckType {
    public JailType(BoardModel boardModel, String id) {
        super(boardModel, id);
    }

    @Override
    public void action() {
        boardModel.jailDeckCard(this);
    }
}
