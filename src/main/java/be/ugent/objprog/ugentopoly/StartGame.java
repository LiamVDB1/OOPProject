package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.fxmlControllers.StartGameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartGame {

    private BoardModel boardModel;
    private StartGameModel model;

    public StartGame(BoardModel boardModel) {
        this.boardModel = boardModel;
        try { start();
        } catch (IOException e) { System.err.println("Error loading StartGame.fxml"); }
    }
    public void start() throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Ugentopoly.class.getResource("fxmlFiles/StartGame.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        StartGameController controller = fxmlLoader.getController();
        controller.setModel(boardModel);
        stage.setTitle("Start een nieuw spel");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
}
