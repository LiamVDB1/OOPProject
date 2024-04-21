package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.fxmlControllers.SpelerCreatorController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class SpelerCreator {

    private BoardModel boardModel;
    private StartGameModel model;
    private List<ChoiceItem> removeChoices;
    public SpelerCreator(BoardModel boardModel, StartGameModel model, List<ChoiceItem> removeChoices) {
        this.boardModel = boardModel;
        this.model = model;
        this.removeChoices = removeChoices;
        try { start();
        } catch (IOException e) { System.err.println("Error loading SpelerCreator.fxml"); }
    }
    public void start() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Ugentopoly.class.getResource("fxmlFiles/SpelerCreator.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        SpelerCreatorController controller = fxmlLoader.getController();
        controller.setBoard(boardModel);
        controller.setModel(model);
        controller.removeChoices(removeChoices);
        stage.setTitle("Speler Toevoegen");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
}
