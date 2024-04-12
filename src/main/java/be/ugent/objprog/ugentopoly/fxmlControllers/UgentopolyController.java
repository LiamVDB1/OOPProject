package be.ugent.objprog.ugentopoly.fxmlControllers;

import be.ugent.objprog.dice.Dice;
import be.ugent.objprog.ugentopoly.Board;
import be.ugent.objprog.ugentopoly.StartGame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UgentopolyController{

    Board board;
    @FXML BorderPane borderPane;
    @FXML GridPane top;
    @FXML GridPane left;
    @FXML StackPane center;
    @FXML GridPane  right;
    @FXML GridPane bottom;

    @FXML AnchorPane cardPane;

    @FXML AnchorPane tileShow;
    @FXML AnchorPane boardShow;
    private final Dice dice = new Dice();
    public void initialize() {
        //Bord initaliseren
        board = new Board(this.borderPane, this.top, this.left, this.center, this.right, this.bottom, this.cardPane, this.boardShow, this.tileShow);

        //Start Game initaliseren
        new StartGame(board);

        //XML File inladen
        try (InputStream input = UgentopolyController.class.getResourceAsStream("/be/ugent/objprog/ugentopoly/ugentopoly.deel1.xml")) {
            Document document = new SAXBuilder().build(input);

            //Root element ophalen
            Element root = document.getRootElement();

            //Settings instellen
            int balance = root.getChild("settings").getAttribute("balance").getIntValue();
            int salary = root.getChild("settings").getAttribute("start").getIntValue();
            board.setBalanceAndSalary(balance, salary);

            //Areas instellen
            board.setAreas(root.getChild("areas"));

            //Tiles instellen
            board.setTiles(root.getChild("tiles"));

        } catch (IOException ex) { System.err.println("Error Loading the XML file - ugentopoly.deel1.xml");
        } catch (JDOMException JE){ System.err.println("JDOMException - ugentopoly.deel1.xml");
        }

        //Properties File inladen + Labels instellen
        try (InputStream input = UgentopolyController.class.getResourceAsStream("/be/ugent/objprog/ugentopoly/ugentopoly.deel1.properties")){
            Properties properties = new Properties();
            properties.load(input);
            board.propertySetup(properties);
        } catch (IOException ex ){ System.err.println("Error Loading the Properties File - ugentopoly.deel1.properties");
        }

        board.setGridPositions();

        Button btn = new Button();
        btn.setText("Rol dobbelstenen");
        btn.setOnAction(event -> dice.roll(t -> System.out.println("Klaar met rollen")));
        boardShow.getChildren().add(btn);
    }

    @FXML
    public void toBoard(){
        board.showBoard();
    }
}
