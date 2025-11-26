package src.FlowerOrderSystem;
import java.util.ArrayList;


public class Order {
    protected final String type;
    private ArrayList<Stem> Flowers;
    private double orderPrice;

    public Order(String type){
        this.type = type;
        Flowers = new ArrayList<>();
    }

    public void addFlower(Stem stem) {
        Flowers.add(stem);
        setPrice();
    }

    public void removeFlower(Stem stem) {
        Flowers.remove(stem);
    }

    public ArrayList<Stem> getFlowers() {
        return Flowers;
    }

    public void setPrice (){
        orderPrice = 0;
//        for(int i = 0; i < Flowers.size(); i++){
//           orderPrice += Flowers.get(i).getPrice();
//        }
        for(Stem flower: Flowers){
            orderPrice += flower.getPrice();
        }
    }

    public double getOrderPrice() {
        return orderPrice;
    }



}
