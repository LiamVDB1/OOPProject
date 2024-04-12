package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.fxmlControllers.StartGameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartGame {

    Board board;
    public StartGame(Board board) {
        this.board = board;
        try { start();
        } catch (IOException e) { System.err.println("Error loading StartGame.fxml"); }
    }
    public void start() throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Ugentopoly.class.getResource("fxmlFiles/StartGame.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        StartGameController controller = fxmlLoader.getController();
        controller.setBoard(board);
        stage.setTitle("Start een nieuw spel");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
}
