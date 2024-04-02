package be.ugent.objprog.ugentopoly;

public class FreeParking extends Tile{
    public FreeParking(int position, String id){
        super(position, id);
    }

    @Override
    public TileMidCard getMidCard() {
        return new FreeParkingMidCard(this);
    }
}
