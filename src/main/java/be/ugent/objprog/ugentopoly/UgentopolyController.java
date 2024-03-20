package be.ugent.objprog.ugentopoly;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UgentopolyController{

    @FXML BorderPane bord;
    @FXML AnchorPane top;
    @FXML AnchorPane left;
    @FXML AnchorPane center;
    @FXML AnchorPane  right;
    @FXML AnchorPane bottom;


    /** Niet geHardCode AnchorPanes.
     public void initialize(){
        for (int i = 0; i < 9; i ++) {
            AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPrefSize(150, 55);

            Double pos = i* 55.0;

            AnchorPane.setTopAnchor(anchorPane,  pos);
            anchorPane.setStyle("-fx-background-color: GREEN");

            right(moet ook voor left, top en bottom.).getChildren().add(anchorPane);
        }
    } */


    //Bord: 148 Lengte, 61 breedte
}
