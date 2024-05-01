package be.ugent.objprog.ugentopoly.deckTypes;

import be.ugent.objprog.ugentopoly.BoardModel;

public class PlayersMoneyType extends DeckType {
    private int amount;
    public PlayersMoneyType(BoardModel boardModel, String id, int amount) {
        super(boardModel, id);
        this.amount = amount;
    }

    @Override
    public void action() {
        boardModel.playersMoneyDeckCard(this, amount);
    }
}
