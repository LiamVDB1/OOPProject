package be.ugent.objprog.ugentopoly.deckTypes;

import be.ugent.objprog.ugentopoly.BoardModel;

public class MoneyType extends DeckType {
    private int amount;
    public MoneyType(BoardModel boardModel, String id, int amount) {
        super(boardModel, id);
        this.amount = amount;
    }

    @Override
    public void action() {
        boardModel.moneyDeckCard(this, amount);
    }
}
