package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.fxmlControllers.SpelerCreatorController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SpelerCreator {

    private BoardModel boardModel;
    public SpelerCreator(BoardModel boardModel) {
        this.boardModel = boardModel;
        try { start();
        } catch (IOException e) { System.err.println("Error loading SpelerCreator.fxml"); }
    }
    public void start() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Ugentopoly.class.getResource("fxmlFiles/SpelerCreator.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        SpelerCreatorController controller = fxmlLoader.getController();
        controller.setBoard(boardModel);
        stage.setTitle("Speler Toevoegen");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
}
