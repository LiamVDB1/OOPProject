package be.ugent.objprog.ugentopoly;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Ugentopoly extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Ugentopoly.class.getResource("fxmlFiles/Ugentopoly.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ugentopoly");
        stage.setScene(scene);
        stage.setResizable(false);
    }
    public static void main(String[] args) {
        launch();
    }
}
