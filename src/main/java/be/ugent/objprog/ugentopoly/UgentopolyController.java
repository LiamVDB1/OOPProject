package be.ugent.objprog.ugentopoly;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Node;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.List;

public class UgentopolyController{

    @FXML BorderPane bord;
    @FXML GridPane top;
    @FXML GridPane left;
    @FXML StackPane center;
    @FXML GridPane  right;
    @FXML GridPane bottom;

    public void initialize() {
        //Properties File inladen + Labels instellen
        try (InputStream input = UgentopolyController.class.getResourceAsStream("ugentopoly.deel1.properties")){
            Properties properties = new Properties();
            properties.load(input);
            gridLabelFiller(left, properties);
            gridLabelFiller(right, properties);
            gridLabelFiller(top, properties);
            gridLabelFiller(bottom, properties);
        } catch (IOException ex ){
            System.err.println("Error Loading the Properties File - ugentopoly.deel1.properties");
        }

        //XML File inladen
        try (InputStream input = UgentopolyController.class.getResourceAsStream("ugentopoly.deel1.xml")) {
            Document document = new SAXBuilder().build(input);
        } catch (IOException ex) {
            System.err.println("Error Loading the XML file - ugentopoly.deel1.xml");
        } catch (JDOMException JE){
            System.err.println("JDOMException - ugentopoly.deel1.xml");
        }

    }

    public void gridLabelFiller(GridPane grid, Properties properties){
        for (Node node : grid.getChildren()){
            if (node instanceof Label && node.getId() != null){
                Label label = (Label) node;
                label.setText(properties.getProperty("tile." + label.getId()));
            } else if (node instanceof Parent){
                Parent parent = (Parent) node;
                for (Node child: parent.getChildrenUnmodifiable()){
                    if (child instanceof Label && child.getId() != null){
                        Label label = (Label) child;
                        label.setText(properties.getProperty("tile." + label.getId()));
                    }
                }
            }
        }
    }
}
