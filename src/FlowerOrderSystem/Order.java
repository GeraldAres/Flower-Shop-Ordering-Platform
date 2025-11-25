package src.FlowerOrderSystem;
import java.util.ArrayList;


public class Order {
    protected final String type;
    private ArrayList<Stem> Flowers;
    private int numOfPieces;
    private double orderPrice;

    public Order(String type){
        this.type = type;
    }

    public void addFlower(Stem stem) {
        Flowers.add(stem);
        numOfPieces++;
    }

    public void removeFlower(Stem stem) {
        Flowers.remove(stem);
        numOfPieces--;
    }

    public ArrayList<Stem> getFlowers() {
        return Flowers;
    }

    public void setPrice (){
        for(int i = 0; i < numOfPieces; i++){
           orderPrice += Flowers.get(i).getPrice();
        }
    }

    public int getNumOfPieces() {
        return numOfPieces;
    }

    public double getOrderPrice() {
        return orderPrice;
    }
}
