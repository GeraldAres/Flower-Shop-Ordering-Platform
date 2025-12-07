package src.FlowerOrderSystem;
import java.util.ArrayList;


public class Order {
    private ArrayList<Stem> Flowers;
    private double orderPrice = 0;

    private Inventory inventory = new Inventory();

    public Order(){
        Flowers = new ArrayList<>();
    }

    public void addFlower (String name) {
        if (name.equals("Rose")){
            Rose rose = new Rose();
            Flowers.add(rose);
            addPrice(rose);
        }
        if (name.equals("Daisy")){
            Daisy daisy = new Daisy();
            Flowers.add(daisy);
            addPrice(daisy);
        }
        if (name.equals("Tulip")){
            Tulip tulip = new Tulip();
            Flowers.add(tulip);
            addPrice(tulip);
        }
        if (name.equals("Carnation")){
            Carnation carnation = new Carnation();
            Flowers.add(carnation);
            addPrice(carnation);
        }
        if (name.equals("Sunflower")){
            Sunflower sunflower = new Sunflower();
            Flowers.add(sunflower);
            addPrice(sunflower);
        }
        if (name.equals("Lily")){
            Lily lily = new Lily();
            Flowers.add(lily);
            addPrice(lily);
        }
    }

    public void removeFlower(String name) {
        for (Stem flower : Flowers){
            if (flower.getName().equalsIgnoreCase(name)){
                Flowers.remove(flower);
                removePrice(flower);
                return;
            }
        }
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



    public ArrayList<Stem> getFlowers() {
        return Flowers;
    }

    public void addPrice (Stem stem){
      orderPrice += stem.getPrice();
    }

    public void removePrice(Stem stem){
        orderPrice -= stem.getPrice();
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void print(){
        for(Stem stem : Flowers){
            System.out.println(stem.getName());
        }
    }


    public int StemStock(String name) {
        return inventory.getStockCount(name);
    }

    public void reduceStemStock(){
        String[] flowerNames = {"Rose", "Daisy", "Tulip", "Carnation", "Sunflower", "Lily"};
        int[] counts = new int[flowerNames.length];

        for (Stem flower : Flowers) {
            String name = flower.getName();
            for (int i = 0; i < flowerNames.length; i++) {
                if (name.equals(flowerNames[i])) {
                    counts[i]++;
                    break;
                }
            }
        }

        for (int i = 0; i < flowerNames.length; i++) {
            if (counts[i] > 0) {
                inventory.updateStock(flowerNames[i], counts[i]);
            }
        }


    }

    public boolean stockIncrease(int ctr, String name) {
        return true;
    }
}
