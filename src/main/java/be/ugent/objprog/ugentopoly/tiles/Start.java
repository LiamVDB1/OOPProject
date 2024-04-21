package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.layout.tileCards.StartCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.StartMidCard;
import javafx.scene.image.Image;

public class Start extends Tile {
    public Start(int position, String id, BoardModel bord) {
        super(position, id, bord);
        imageCreate("start.png");
    }

    @Override
    public void initializeCards() {
        this.card = new StartCard(this);
        this.midCard = new StartMidCard(this);
    }

    public Image getStartArrow(){
        // Dit is niet zo mooie code, maar het is om code duplicatie te vermijden.
        Image graphic = this.image;
        imageCreate("start-arrow.png");
        Image startArrow = this.image;
        this.image = graphic;
        return startArrow;
    }
}
