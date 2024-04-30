package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.Speler;
import be.ugent.objprog.ugentopoly.layout.tileCards.RailwayCard;
import be.ugent.objprog.ugentopoly.layout.tileMidCards.RailwayMidCard;
import be.ugent.objprog.ugentopoly.BoardModel;
import java.util.Map;

public class Railway extends Eigendom {
    public Railway(int position, String id, int cost, int huur, BoardModel bord){
        super(position, id, bord, cost, huur);
        imageCreate("railway.png");
    }

    @Override
    public void initializeCards() {
        this.card = new RailwayCard(this, vertical, LT);
        this.midCard = new RailwayMidCard(this);
    }

    @Override
    public void setEigenaar(Speler speler){
        super.setEigenaar(speler);
        speler.addRailway(this);
        for (Railway railway : speler.getRailways()){
            railway.setHuur(railway.getBasisHuur() * (int) Math.pow(2,  speler.getRailways().size() - 1));
        }
    }
}
