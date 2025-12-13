package src.FlowerOrderSystem;
import java.util.ArrayList;


public class Order {
    private ArrayList<InBloom> Flowers;
    private double orderPrice = 0;
    private Inventory inventory = new Inventory();
    public Order(){
        Flowers = new ArrayList<>();
    }



    public void addFlower (String name, boolean isBouquet) {
        Factory factory;
        if (!isBouquet){
            factory = new StemFactory();
            Flowers.add(factory.addInBloom(name));
            factory = null;
        }

        if(isBouquet){
           //  factory = new BouquetFactory();
            // add flowers pero amount is dependent sa size sa bouquet (find logic unsaon pagkuha ato)
        }

    }

    public void removeFlower(String name) {
        for (InBloom flower : Flowers){
            if (flower.getName().equalsIgnoreCase(name)){
                Flowers.remove(flower);
                removePrice((Stem) flower);
                return;
            }
        }
    }

    public int count(String name){
        int c = 0;

        for(InBloom flower : Flowers){
            if(flower.getName().equalsIgnoreCase(name)){
                c++;
            }
        }

        return c;
    }



    public ArrayList<InBloom> getFlowers() {
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
        for(InBloom stem : Flowers){
            System.out.println(stem.getName());
        }
    }


    public int StemStock(String name) {
        return inventory.getStockCount(name);
    }

    public void reduceStemStock(){
        String[] flowerNames = {"Rose", "Daisy", "Tulip", "Carnation", "Sunflower", "Lily"};
        int[] counts = new int[flowerNames.length];

        for (InBloom flower : Flowers) {
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
       if (ctr < inventory.getStockCount(name)) {
           return true;
       }
        return false;
    }

    public double getPrice (String name){
        Stem temp;
        if (name.equals("Rose")){
            temp = new Rose();
            return temp.getPrice();
        }
        if (name.equals("Daisy")){
            temp = new Daisy();
            return temp.getPrice();
        }
        if (name.equals("Tulip")){
            temp = new Tulip();
            return temp.getPrice();
        }
        if (name.equals("Carnation")){
            temp = new Carnation();
            return temp.getPrice();
        }
        if (name.equals("Sunflower")){
            temp = new Sunflower();
            return temp.getPrice();
        }
        if (name.equals("Lily")){
            temp = new Lily();
            return temp.getPrice();
        }
        return 0.00;
    }

    public String getColor (String name){
        Stem temp;
        if (name.equals("Rose")){
            temp = new Rose();
            return temp.getColor();
        }
        if (name.equals("Daisy")){
            temp = new Daisy();
            return temp.getColor();
        }
        if (name.equals("Tulip")){
            temp = new Tulip();
            return temp.getColor();
        }
        if (name.equals("Carnation")){
            temp = new Carnation();
            return temp.getColor();
        }
        if (name.equals("Sunflower")){
            temp = new Sunflower();
            return temp.getColor();
        }
        if (name.equals("Lily")){
            temp = new Lily();
            return temp.getColor();
        }
        return "White";
    }
}
