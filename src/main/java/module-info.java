module be.ugent.objprog.ugentopoly {
    requires javafx.controls;
    requires javafx.fxml;
    requires be.ugent.objprog.dice;
    requires jdom;

    opens be.ugent.objprog.ugentopoly to javafx.fxml;
    exports be.ugent.objprog.ugentopoly;
    exports be.ugent.objprog.ugentopoly.factories;
    opens be.ugent.objprog.ugentopoly.factories to javafx.fxml;
    exports be.ugent.objprog.ugentopoly.tiles;
    opens be.ugent.objprog.ugentopoly.tiles to javafx.fxml;
    exports be.ugent.objprog.ugentopoly.layout.tileCards;
    opens be.ugent.objprog.ugentopoly.layout.tileCards to javafx.fxml;
    exports be.ugent.objprog.ugentopoly.layout.tileMidCards;
    opens be.ugent.objprog.ugentopoly.layout.tileMidCards to javafx.fxml;
    exports be.ugent.objprog.ugentopoly.fxmlControllers;
    opens be.ugent.objprog.ugentopoly.fxmlControllers to javafx.fxml;
}