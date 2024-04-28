package be.ugent.objprog.ugentopoly.fxmlControllers;

import be.ugent.objprog.ugentopoly.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.util.List;

public class SpelerCreatorController {
    private BoardModel boardModel;
    private StartGameModel model;

    @FXML TextField naam;
    @FXML ComboBox<Pion> pionChoice;
    @FXML ColorPicker colorPicker;
    @FXML Label errorNaam;

    public void initialize(){
        setupComboBox();

        pionChoice.getItems().addAll(
                Pion.WINA,
                Pion.VTK,
                Pion.CHEMICA,
                Pion.FILOLOGICA,
                Pion.GEOLOGICA,
                Pion.VBK,
                Pion.VEK,
                Pion.VLK
        );
        //pionChoice.setValue(pionChoice.getItems().get(0)); Overbodig, want dit gebeurt in removeChoices
        colorPicker.setValue(Color.TEAL);
    }

    public void setBoard(BoardModel boardModel) {
        this.boardModel = boardModel;
    }
    public void setModel(StartGameModel model) {
        this.model = model;
    }
    public void removeChoices(List<Pion> items){
        pionChoice.getItems().removeAll(items);
        pionChoice.setValue(pionChoice.getItems().get(0));
    }
    private void setupComboBox(){
        //Zorgen dat Images in de combobox getoond worden
        pionChoice.setCellFactory(o -> new ListCell<Pion>() {
            private final ImageView imageView = new ImageView();
            {
                imageView.setPreserveRatio(true);
                imageView.setFitHeight(20);
            }
            @Override
            protected void updateItem(Pion item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                    setText(null);
                } else {
                    setText(item.getText());
                    imageView.setImage(item.getImage());
                    setGraphic(imageView);
                }
            }
        });
        pionChoice.setButtonCell(new ListCell<Pion>(){
            private final ImageView imageView = new ImageView();
            {
                imageView.setPreserveRatio(true);
                imageView.setFitHeight(20);
            }
            @Override
            protected void updateItem(Pion item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                    setText(null);
                } else {
                    setText(item.getText());
                    imageView.setImage(item.getImage());
                    setGraphic(imageView);
                }
            }
        });
    }
    @FXML
    public void close(){
        Stage stage = (Stage) pionChoice.getScene().getWindow();
        stage.close();
    }

    @FXML
    public boolean checkText(){
        if(naam.getText().isEmpty()){
            naam.getStyleClass().add("wrongText");
            errorNaam.setVisible(true);
            return false;
        } else {
            if (naam.getStyleClass().contains("wrongText")) { naam.getStyleClass().remove("wrongText"); }
            if (errorNaam.isVisible()){ errorNaam.setVisible(false); }
            return true;
        }
    }

    @FXML
    public void addSpeler(){
        if (checkText()){
            model.addSpeler(naam.getText(), pionChoice.getValue(), colorPicker.getValue());
            pionChoice.getItems().remove(pionChoice.getValue());
            close();
        }
    }
}



