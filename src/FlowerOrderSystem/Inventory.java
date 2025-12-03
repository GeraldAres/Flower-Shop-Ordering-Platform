package src.FlowerOrderSystem;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Locale;

public class Inventory {
    private ArrayList<Rose> roses = new ArrayList<>();
    private ArrayList<Sunflower> sunflowers = new ArrayList<>();
    private ArrayList<Lily> lilies = new ArrayList<>();
    private ArrayList<Daisy> daisies = new ArrayList<>();
    private ArrayList<Carnation> carnations = new ArrayList<>();
    private ArrayList<Tulip> tulips = new ArrayList<>();
    private final int defaultStock = 50;

    private void initializeStock() {
        for (int i = 0; i < defaultStock; i++) {
            roses.add(new Rose("Red"));
            sunflowers.add(new Sunflower("Yellow"));
            lilies.add(new Lily("White"));
            daisies.add(new Daisy("White"));
            carnations.add(new Carnation("Red"));
            tulips.add(new Tulip("Purple"));
        }
    }

    public Inventory() {
        initializeStock();
    }

    public <T> boolean removeFlowers(ArrayList<T> list, int quantity, String typeName) {
        if (list.size() >= quantity) {
            for (int i = 0; i < quantity; i++) {
                list.remove(0);
            }
            System.out.println("Inventory Update: Sold " + quantity + " " + typeName + "(s). Remaining: " + list.size());
            return true;
        } else {
            System.out.println("Failed: Not enough stock for " + typeName + ". Requested: " + quantity + ", Availability: " + list.size());
            return false;
        }
    }

    public boolean updateStock(String flowerName, int quantity) {
        String name = flowerName.toLowerCase().trim();
            switch(name) {
                case "rose":
                    return removeFlowers(roses, quantity, "Rose");
                case "sunflower":
                    return removeFlowers(sunflowers, quantity, "Sunflower");
                case "lily":
                    return removeFlowers(lilies, quantity, "Lily");
                case "daisy":
                    return removeFlowers(daisies, quantity, "Daisy");
                case "carnation":
                    return removeFlowers(carnations, quantity, "Carnation");
                case "tulip":
                    return removeFlowers(tulips,  quantity, "Tulip");
                default:
                    System.out.println("Error: Flower type '" + flowerName + "' not found.");
                    return false;
            }
    }

    public int getStockCount(String flowerName) {
        switch(flowerName.toLowerCase().trim()) {
            case "rose":
                return roses.size();
            case "sunflower":
                return sunflowers.size();
            case "lily":
                return lilies.size();
            case "daisy":
                return daisies.size();
            case "carnation":
                return carnations.size();
            case "tulip":
                return tulips.size();
            default:
                return 0;
        }
    }

    public void displayInventoryStock() {
        System.out.println("\n--- CURRENT INVENTORY STATUS ---");
        System.out.println("Roses:        " + roses.size());
        System.out.println("Sunflowers:   " + sunflowers.size());
        System.out.println("Lilies:       " + lilies.size());
        System.out.println("Daisies:      " + daisies.size());
        System.out.println("Carnations:   " + carnations.size());
        System.out.println("Tulips:       " + tulips.size());
        System.out.println("--------------------------------");
    }
}