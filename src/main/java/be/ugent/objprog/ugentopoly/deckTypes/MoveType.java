package be.ugent.objprog.ugentopoly.deckTypes;

import be.ugent.objprog.ugentopoly.BoardModel;

public class MoveType extends DeckType {
    private boolean collect;
    private int position;
    public MoveType(BoardModel boardModel, String id, boolean collect, int position) {
        super(boardModel, id);
        this.collect = collect;
        this.position = position;
    }

    @Override
    public void action() {
        boardModel.moveDeckCard(this, collect, position);
    }
}
