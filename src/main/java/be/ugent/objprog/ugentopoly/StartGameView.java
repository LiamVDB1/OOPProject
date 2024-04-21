package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.layout.StartSpelerCard;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.List;
import java.util.Map;

public class StartGameView implements InvalidationListener {

    private int playerCount;
    private GridPane grid;
    private BoardModel boardModel;
    private Label errorMessage;
    private Map<Integer, GridPosition> Positions;
    private record GridPosition(int columnIndex, int rowIndex) {}

    public StartGameView(BoardModel boardModel, GridPane grid,StartGameModel model, Label errorMessage) {
        this.boardModel = boardModel;
        this.grid = grid;
        this.errorMessage = errorMessage;
        model.addListener(this);
        playerCount = 0;
        Positions = Map.of(
                0, new GridPosition(0, 0),
                1, new GridPosition(1, 0),
                2, new GridPosition(0, 1),
                3, new GridPosition(1, 1)
        );
    }

    @Override
    public void invalidated(Observable observable) {
        List<Speler> spelers = boardModel.getSpelers();
        makeSpeler(spelers.get(spelers.size() - 1));
        playerCount ++;
    }
    public void makeSpeler(Speler speler){
        boolean whiteText = ! (ColorLuminance.calculateLuminance(speler.getColor()) > 0.4);
        GridPosition gridPosition = Positions.get(playerCount);
        //Template removen
        grid.getChildren().removeIf(node -> node.getStyleClass().contains("template") && GridPane.getRowIndex(node) == gridPosition.rowIndex() && GridPane.getColumnIndex(node) == gridPosition.columnIndex());
        grid.add(new StartSpelerCard(speler, whiteText), gridPosition.columnIndex(), gridPosition.rowIndex());
    }
    public void showError(){
        errorMessage.setVisible(true);
    }
    public void hideError(){
        errorMessage.setVisible(false);
    }
}
