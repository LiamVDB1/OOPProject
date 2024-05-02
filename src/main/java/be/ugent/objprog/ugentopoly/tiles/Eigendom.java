package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.BoardModel;
import be.ugent.objprog.ugentopoly.Speler;

public abstract class Eigendom extends Tile{

    private int cost;
    private int basisHuur;
    private int huur;
    private Speler eigenaar;

    public Eigendom(int position, String id, BoardModel boardModel, int cost, int basisHuur){
        super(position, id, boardModel);
        this.cost = cost;
        this.basisHuur = basisHuur;
        this.huur = basisHuur;
        this.eigenaar = null;
    }

    public void setHuur(int huur){
        this.huur = huur;
    }
    public int getHuur(){
        return huur;
    }
    public int getBasisHuur(){
        return basisHuur;
    }
    public int getCost(){
        return cost;
    }
    public Speler getEigenaar(){
        return eigenaar;
    }
    public void setEigenaar(Speler speler){
        this.eigenaar = speler;
    }
    @Override
    public abstract void initializeCards();

    @Override
    public void action() {
        if (eigenaar == null){
            boardModel.showBuyEigendom(this);
        }
        else if (eigenaar != boardModel.getCurrentSpeler()){
            boardModel.betaalHuur(this);
        }
    }
}
