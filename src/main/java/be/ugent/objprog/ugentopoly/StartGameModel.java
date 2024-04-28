package be.ugent.objprog.ugentopoly;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class StartGameModel implements Observable {

    private List<InvalidationListener> listeners;
    private BoardModel boardModel;
    private StartGameView view;
    private List<Pion> removeChoices;

    public StartGameModel(BoardModel boardModel, GridPane grid, Label errorMessage) {
        this.boardModel = boardModel;
        listeners = new ArrayList<>();
        this.view = new StartGameView(boardModel, grid, this, errorMessage);
        this.removeChoices = new ArrayList<>();
    }
    @Override
    public void addListener(InvalidationListener invalidationListener) {
        listeners.add(invalidationListener);
    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {
        listeners.remove(invalidationListener);
    }

    public void spelerToevoegen(){
        new SpelerCreator(boardModel, this, removeChoices);
    }

    public void addSpeler(String naam, Pion pion, Color color){
        if (boardModel.getSpelers().size() <= 4) {
            Speler speler = new Speler(naam, pion, color, boardModel);
            removeChoices.add(pion);
            boardModel.addSpeler(speler);
            fireInvalidationEvent();
            view.hideError();
        } else {
            view.showError();
        }
    }

    public void fireInvalidationEvent() {
        for (InvalidationListener listener : listeners) {
            listener.invalidated(this);
        }
    }

    public void startSpel(){
        if (boardModel.getSpelers().size() >= 2 && boardModel.getSpelers().size() <= 4) {
            boardModel.startSpel();
            view.hideError();
        } else {
            view.showError();
        }
    }
}
