package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.dice.Dice;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Ugentopoly extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        //final Dice dice = new Dice();

        //Button btn = new Button();
        //btn.setText("Rol dobbelstenen");
        //btn.setOnAction(event -> dice.roll(t -> System.out.println("Klaar met rollen")));

        FXMLLoader fxmlLoader = new FXMLLoader(Ugentopoly.class.getResource("Ugentopoly.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ugentopoly");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);


    }
    public static void main(String[] args) {
        launch();
    }
}