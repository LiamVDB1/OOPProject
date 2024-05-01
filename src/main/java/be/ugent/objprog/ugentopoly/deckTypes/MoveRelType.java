package be.ugent.objprog.ugentopoly.deckTypes;

import be.ugent.objprog.ugentopoly.BoardModel;

public class MoveRelType extends DeckType {
    private int relative;
    public MoveRelType(BoardModel boardModel, String id, int relative) {
        super(boardModel, id);
        this.relative = relative;
    }

    @Override
    public void action() {
        boardModel.moveRelDeckCard(this, relative);
    }
}
