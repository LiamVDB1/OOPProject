package be.ugent.objprog.ugentopoly;

public class Tax extends Tile{
    int amount;
    public Tax(int position, String id, int amount){
        super(position, id);
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    @Override
    public TileMidCard getMidCard() {
        return new TaxMidCard(this);
    }
}
