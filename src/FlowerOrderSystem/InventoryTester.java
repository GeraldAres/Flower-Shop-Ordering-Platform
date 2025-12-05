package src.FlowerOrderSystem;

public class InventoryTester {
    public static void main(String[] args) {
        // 1. Create the inventory (Automatically fills with 50 of each)
        Inventory inventory = new Inventory();

        inventory.displayInventoryStock();

        // 2. Simulate a User Ordering 3 Roses
        System.out.println("\nUser ordering 3 Roses...");
        boolean success = inventory.updateStock("Rose", 3);

        if (success) {
            // Proceed with payment and saving order to file
            System.out.println("Order processed successfully.");
        } else {
            System.out.println("Order failed. Out of stock.");
        }

        // 3. Simulate ordering too many Sunflowers
        System.out.println("\nUser ordering 100 Sunflowers...");
        inventory.updateStock("Sunflower", 100);

        // 4. Check final status
        inventory.displayInventoryStock();
    }
}