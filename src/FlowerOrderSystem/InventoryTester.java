package src.FlowerOrderSystem;

import java.io.*;

public class InventoryTester {

    public static void main(String[] args) {
        System.out.println("====== STARTING INVENTORY SYSTEM TEST ======");

        // --- PREPARATION: DELETE OLD FILE ---
        // We delete the existing file to ensure we are testing the "Auto-Create" feature.
        File file = new File("Stocks/stocks.csv");
        if (file.exists()) {
            file.delete();
            System.out.println("Note: Deleted old 'stocks.csv' for a fresh test.");
        }

        // --- TEST 1: INITIALIZATION (Auto-Create File) ---
        System.out.println("\n--- Test 1: System Initialization ---");
        // This should detect the missing file and create it with 50 items each
        Inventory inventory = new Inventory();

        int roseCount = inventory.getStockCount("Rose");
        if (roseCount == 50 && file.exists()) {
            System.out.println("✔ PASS: File created. Default Rose stock is 50.");
        } else {
            System.out.println("❌ FAIL: Stock is " + roseCount + " (Expected 50) or file missing.");
        }


        // --- TEST 2: USER PURCHASE (Buying 5 Roses) ---
        System.out.println("\n--- Test 2: User Buys 5 Roses ---");
        boolean buySuccess = inventory.updateStock("Rose", 5);

        if (buySuccess && inventory.getStockCount("Rose") == 45) {
            System.out.println("✔ PASS: Sale successful. Rose stock dropped to 45.");
        } else {
            System.out.println("❌ FAIL: Sale failed or count is wrong.");
        }


        // --- TEST 3: OWNER RESTOCK (Adding 20 Roses) ---
        System.out.println("\n--- Test 3: Owner Adds 20 Roses ---");
        // 45 + 20 should be 65
        inventory.replenishStock("Rose", 20);

        if (inventory.getStockCount("Rose") == 65) {
            System.out.println("✔ PASS: Restock successful. Rose stock rose to 65.");
        } else {
            System.out.println("❌ FAIL: Count is " + inventory.getStockCount("Rose"));
        }


        // --- TEST 4: FILE PERSISTENCE CHECK ---
        System.out.println("\n--- Test 4: Verifying the CSV File content ---");
        // We read the raw file to make sure the "65" was actually saved to disk
        String roseLine = getRoseLineFromFile();

        System.out.println("Raw File Content for Rose: [" + roseLine + "]");

        if (roseLine.equals("Rose,Red,65")) {
            System.out.println("✔ PASS: File matches system memory exactly.");
        } else {
            System.out.println("❌ FAIL: File was not updated correctly.");
        }

        // --- FINAL INVENTORY DUMP ---
        inventory.displayInventoryStock();
    }

    // Helper method to peek inside the CSV file
    private static String getRoseLineFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("Stocks/stocks.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Rose,")) {
                    return line;
                }
            }
        } catch (IOException e) {
            return "ERROR_READING_FILE";
        }
        return "ROSE_NOT_FOUND";
    }
}