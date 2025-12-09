package src.FlowerOrderSystem;

public class OwnerTester {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // 1. Show initial stock
        inventory.displayInventoryStock();

        // 2. SIMULATE OWNER ADDING STOCK
        System.out.println("\n>>> Owner is restocking 50 Roses...");
        inventory.replenishStock("Rose", 50);

        // 3. SIMULATE OWNER ADDING STOCK
        System.out.println("\n>>> Owner is restocking 10 Sunflowers...");
        inventory.replenishStock("Sunflower", 10);

        // 4. Show final stock
        inventory.displayInventoryStock();

        // 5. CHECK YOUR FILE!
        // Open Stocks/stocks.csv.
        // Roses should now be 100 (if it started at 50).
        // Sunflowers should be 60.
    }
}