package src.FlowerOrderSystem;

import java.util.*;
import java.io.*;

public class Inventory {
    private ArrayList<Rose> roses = new ArrayList<>();
    private ArrayList<Sunflower> sunflowers = new ArrayList<>();
    private ArrayList<Lily> lilies = new ArrayList<>();
    private ArrayList<Daisy> daisies = new ArrayList<>();
    private ArrayList<Carnation> carnations = new ArrayList<>();
    private ArrayList<Tulip> tulips = new ArrayList<>();
    private final String filePath = "Stocks/stocks.csv";

    public Inventory() {
        loadStockFromFile();
    }

    private void loadStockFromFile() {
        File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("Notice: " + filePath + " not found. Creating default...");
                initializeDefaultStock();
                saveInventoryToFile();
                return;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                    while ((line = br.readLine()) != null) {
                        if (line.trim().isEmpty()) {
                            continue;
                        }

                        String[] parts = line.split(",");
                            if (parts.length == 3) {
                                String flowerName = parts[0].trim();
                                int quantity = Integer.parseInt(parts[2].trim());
                                addToInternalList(flowerName, quantity);
                            }
                    }
            } catch (Exception e) {
                e.printStackTrace();
                initializeDefaultStock();
            }
    }

    public void saveInventoryToFile() {
        File file = new File(filePath);
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                String roseColor = "Red";
                bw.write("Rose," + roseColor + "," + roses.size());
                bw.newLine();

                String sunflowerColor = "Yellow";
                bw.write("Sunflower," + sunflowerColor + "," + sunflowers.size());
                bw.newLine();

                String lilyColor = "Pink";
                bw.write("Lily," + lilyColor + "," + lilies.size());
                bw.newLine();

                String daisyColor = "White";
                bw.write("Daisy," + daisyColor + "," + daisies.size());
                bw.newLine();

                String carnationColor = "Orange";
                bw.write("Carnation," + carnationColor + "," + carnations.size());
                bw.newLine();

                String tulipColor = "Purple";
                bw.write("Tulip," + tulipColor + "," + tulips.size());
                bw.newLine();

                System.out.println("System: Inventory database updated successfully.");
            } catch (IOException e) {
                System.err.println("Error saving inventory: " + e.getMessage());
            }
    }

    public void replenishStock(String flowerName, int quantity) {
        addToInternalList(flowerName, quantity);
        System.out.println("Owner Action: Added " + quantity + " to " + flowerName);
        saveInventoryToFile();
    }

    public boolean updateStock(String flowerName, int quantity) {
        String name = flowerName.toLowerCase().trim();
        boolean success = false;

            switch(name) {
                case "rose":
                    success = removeFlowers(roses, quantity, "Rose");
                    break;
                case "sunflower":
                    success = removeFlowers(sunflowers, quantity, "Sunflower");
                    break;
                case "lily":
                    success = removeFlowers(lilies, quantity, "Lily");
                    break;
                case "daisy":
                    success = removeFlowers(daisies, quantity, "Daisy");
                    break;
                case "carnation":
                    success = removeFlowers(carnations, quantity, "Carnation");
                    break;
                case "tulip":
                    success = removeFlowers(tulips,  quantity, "Tulip");
                    break;
                default:
                    return false;
            }

        if (success) {
            saveInventoryToFile();
        }

        return success;
    }

    private void addToInternalList(String name, int quantity) {
        for (int i = 0; i < quantity; i++) {
            switch (name.toLowerCase()) {
                case "rose":
                    roses.add(new Rose());
                    break;
                case "sunflower":
                    sunflowers.add(new Sunflower());
                    break;
                case "lily":
                    lilies.add(new Lily());
                    break;
                case "daisy":
                    daisies.add(new Daisy());
                    break;
                case "carnation":
                    carnations.add(new Carnation());
                    break;
                case "tulip":
                    tulips.add(new Tulip());
                    break;
            }
        }
    }

    private void initializeDefaultStock() {
        addToInternalList("rose", 50);
        addToInternalList("sunflower", 50);
        addToInternalList("lily", 50);
        addToInternalList("daisy", 50);
        addToInternalList("carnation", 50);
        addToInternalList("tulip", 50);
    }

    private <T> boolean removeFlowers(ArrayList<T> list, int quantity, String typeName) {
        if (list.size() >= quantity) {
            for (int i = 0; i < quantity; i++) {
                list.remove(0);
            }
            return true;
        } else {
            System.out.println("Not enough stock for " + typeName);
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
        System.out.println("\n--- CURRENT INVENTORY ---");
        System.out.println("Roses:      " + roses.size());
        System.out.println("Sunflowers: " + sunflowers.size());
        System.out.println("Lilies:     " + lilies.size());
        System.out.println("Daisies:    " + daisies.size());
        System.out.println("Carnations: " + carnations.size());
        System.out.println("Tulips:     " + tulips.size());
        System.out.println("-------------------------");
    }
}