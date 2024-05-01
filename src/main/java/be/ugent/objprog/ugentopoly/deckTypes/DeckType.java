package be.ugent.objprog.ugentopoly.deckTypes;

import be.ugent.objprog.ugentopoly.BoardModel;

public abstract class DeckType {
    protected String id;
    protected String text;
    protected BoardModel boardModel;

    public DeckType(BoardModel boardModel, String id){
        this.id = id;
        this.boardModel = boardModel;
    }

    public String getId(){
        return id;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public abstract void action();
}
