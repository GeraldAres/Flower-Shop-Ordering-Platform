package src.FlowerOrderSystem;
import java.util.ArrayList;


public class Order {
    protected final String type;
    private ArrayList<Stem> Flowers;
    private double orderPrice;

    public Order(String type){
        this.type = type;
    }

    public void addFlower(Stem stem) {
        Flowers.add(stem);
    }

    public void removeFlower(Stem stem) {
        Flowers.remove(stem);
    }

    public ArrayList<Stem> getFlowers() {
        return Flowers;
    }

    public void setPrice (){
        for(int i = 0; i < Flowers.size(); i++){
           orderPrice += Flowers.get(i).getPrice();
        }
    }

    public double getOrderPrice() {
        return orderPrice;
    }



}
