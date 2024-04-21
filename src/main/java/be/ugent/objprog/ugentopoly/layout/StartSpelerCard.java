package be.ugent.objprog.ugentopoly.layout;

import be.ugent.objprog.ugentopoly.Card;
import be.ugent.objprog.ugentopoly.Speler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class StartSpelerCard extends Card {
    private Speler speler;
    private boolean whiteText;
    public StartSpelerCard(Speler speler, boolean whiteText){
        super();
        this.speler = speler; this.whiteText = whiteText;
        AnchorPane.setTopAnchor(this, 0.0); AnchorPane.setLeftAnchor(this, 0.0); AnchorPane.setRightAnchor(this, 0.0); AnchorPane.setBottomAnchor(this, 0.0);
        this.setPrefSize(190, 190);
        initialize();
    }

    public void initialize(){
        this.setStyle("-fx-background-color: " + '"' +  speler.getColor().toString() + '"' + ";");

        ImageView pion = makeImage();

        Label name = makeLabel();

        AnchorPane.setTopAnchor(pion, 30.0);
        AnchorPane.setTopAnchor(name, 130.0);

        this.getChildren().addAll(pion, name);
    }

    public Label makeLabel(){
        Label label = everyLabel(speler.getNaam());
        if (whiteText){ label.setStyle("-fx-text-fill: white;"); }
        AnchorPane.setRightAnchor(label, 0.0);
        AnchorPane.setLeftAnchor(label, 0.0);
        return label;
    }
    public ImageView makeImage(){
        ImageView pion = new ImageView(speler.getPion().getImage());
        pion.setStyle("-fx-border-color: white;");
        pion.setPreserveRatio(true);
        AnchorPane.setLeftAnchor(pion, 65.0);
        AnchorPane.setRightAnchor(pion, 65.0);
        pion.setFitWidth(60.0);
        return pion;
    }
}
