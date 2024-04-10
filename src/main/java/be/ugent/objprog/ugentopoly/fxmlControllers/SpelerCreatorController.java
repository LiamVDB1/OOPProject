package be.ugent.objprog.ugentopoly.fxmlControllers;

import be.ugent.objprog.ugentopoly.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SpelerCreatorController {
    private BoardModel boardModel;

    @FXML TextField naam;
    @FXML ComboBox<ChoiceItem> pionChoice;
    @FXML ColorPicker colorPicker;
    @FXML Label errorNaam;

    public void initialize(){
        setupComboBox();

        pionChoice.getItems().addAll(
                new ChoiceItem("WINA", new Image(this.getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/token1.png"))),
                new ChoiceItem("VTK", new Image(this.getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/token2.png"))),
                new ChoiceItem("Chemica",  new Image(this.getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/token3.png"))),
                new ChoiceItem("Filologica", new Image(this.getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/token4.png"))),
                new ChoiceItem("Geologica", new Image(this.getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/token5.png"))),
                new ChoiceItem("VBK", new Image(this.getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/token6.png"))),
                new ChoiceItem("VEK", new Image(this.getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/token7.png"))),
                new ChoiceItem("VLK", new Image(this.getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/token8.png")))
        );
        pionChoice.setValue(pionChoice.getItems().get(0));
    }

    public void setBoard(BoardModel boardModel) {
        this.boardModel = boardModel;
    }

    private void setupComboBox(){
        //Zorgen dat Images in de combobox getoond worden
        pionChoice.setCellFactory(o -> new ListCell<ChoiceItem>() {
            private final ImageView imageView = new ImageView();
            {
                imageView.setPreserveRatio(true);
                imageView.setFitHeight(20);
            }
            @Override
            protected void updateItem(ChoiceItem item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                    setText(null);
                } else {
                    setText(item.text());
                    imageView.setImage(item.image());
                    setGraphic(imageView);
                }
            }
        });
        pionChoice.setButtonCell(new ListCell<ChoiceItem>(){
            private final ImageView imageView = new ImageView();
            {
                imageView.setPreserveRatio(true);
                imageView.setFitHeight(20);
            }
            @Override
            protected void updateItem(ChoiceItem item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                    setText(null);
                } else {
                    setText(item.text());
                    imageView.setImage(item.image());
                    setGraphic(imageView);
                }
            }
        });
    }
    @FXML
    public void cancel(){
        Stage stage = (Stage) pionChoice.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void checkText(){
        if(naam.getText().isEmpty()){
            naam.getStyleClass().add("wrongText");
            errorNaam.setVisible(true);
        } else {
            if (naam.getStyleClass().contains("wrongText")) { naam.getStyleClass().remove("wrongText"); }
            if (errorNaam.isVisible()){ errorNaam.setVisible(false); }
        }
    }

    @FXML
    public void addSpeler(){
        checkText();
    }
}



