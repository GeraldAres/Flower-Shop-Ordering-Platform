package src.FlowerOrderSystem;
import java.util.ArrayList;


public class Order {
    protected final String type;
    private ArrayList<Stem> Flowers;
    private double orderPrice;

    private Inventory inventory = new Inventory();

    public Order(String type){
        this.type = type;
        Flowers = new ArrayList<>();
    }

    public void addFlower(Stem stem) {
        Flowers.add(stem);
        setPrice();
    }

    public int count(String name){
        int c = 0;

        for(Stem stem : Flowers){
            if(stem.getName().equalsIgnoreCase(name)){
                c++;
            }
        }

        return c;
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

    public void print(){
        for(Stem stem : Flowers){
            System.out.println(stem.getName());
        }
    }



}
