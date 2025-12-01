package src.FlowerOrderSystem;

import java.io.File;
import java.util.ArrayList;

public class MultiUserTest {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   MULTI-USER FOLDER STRUCTURE TEST");
        System.out.println("==========================================\n");

        // 1. Define 3 Different Users
        String[] users = {"Chloe", "Iren", "Mary"};

        // CLEANUP: Delete the main 'Orders' folder to start fresh (Optional)
        // cleanMainFolder();

        // --- STEP 1: Save Orders for Each User ---
        System.out.println(">>> STEP 1: Creating and Saving Orders...");

        for (String user : users) {
            System.out.println("   Processing User: " + user);

            // Create a dummy order
            CheckOut order = new CheckOut(null);
            order.setModeOfDelivery("Delivery");
            order.setAddressOfDelivery("Street of " + user);
            order.setTotalPrice(Math.random() * 1000); // Random price
            order.setOrderStatus("Paid");

            // Save it
            order.saveOrderToUserFolder(user);

            // PAUSE: We wait 1 second to ensure the IDs (filenames) are unique
            // because your ID format is based on seconds (HHmmss).
            forceWait(1100);
        }

        // --- STEP 2: Verify Folder Structure Physically ---
        System.out.println("\n>>> STEP 2: Verifying File System Structure...");

        File mainFolder = new File("Orders");
        if (!mainFolder.exists()) {
            System.err.println("   [FAIL] Main 'Orders' folder does not exist!");
            return;
        }

        for (String user : users) {
            File userFolder = new File(mainFolder, user);

            if (userFolder.exists() && userFolder.isDirectory()) {
                System.out.println("   [PASS] Folder found: Orders/" + user);

                // Check if there is a file inside
                File[] files = userFolder.listFiles();
                if (files != null && files.length > 0) {
                    System.out.println("          -> Contains " + files.length + " order file(s).");
                } else {
                    System.err.println("          -> [FAIL] Folder is empty!");
                }
            } else {
                System.err.println("   [FAIL] Missing folder for: " + user);
            }
        }


        // --- STEP 3: Verify ViewOrder Isolation ---
        // We check if loading "Alice" ONLY loads Alice's data and not Bob's.
        System.out.println("\n>>> STEP 3: Verifying Data Isolation (ViewOrder)...");

        ViewOrder viewer = new ViewOrder();

        // Load Alice
        System.out.println("   Loading orders for: " + users[0]); // Alice
        viewer.loadFromFile(users[0]);
        ArrayList<CheckOut> aliceOrders = viewer.getAllOrders();

        if (aliceOrders.size() == 1) {
            CheckOut o = aliceOrders.get(0);
            System.out.println("   [PASS] Alice has exactly 1 order.");

            // Verify the data belongs to Alice
            if (o.getAddressOfDelivery().contains(users[0])) {
                System.out.println("   [PASS] The order content belongs to Alice.");
            } else {
                System.err.println("   [FAIL] Data mismatch! Address: " + o.getAddressOfDelivery());
            }
        } else {
            System.err.println("   [FAIL] Alice should have 1 order, found: " + aliceOrders.size());
        }

        // Try loading a user that doesn't exist
        System.out.println("   Loading orders for: Ghost_User");
        viewer.loadFromFile("Ghost_User");
        if (viewer.getAllOrders().isEmpty()) {
            System.out.println("   [PASS] Ghost_User has 0 orders (Correct).");
        } else {
            System.err.println("   [FAIL] Ghost_User found data? Impossible.");
        }

        System.out.println("\n==========================================");
        System.out.println("   TEST COMPLETE");
        System.out.println("==========================================");
    }

    // --- Helper to pause execution ---
    private static void forceWait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // --- Helper to clean folder (Optional) ---
    private static void cleanMainFolder() {
        File folder = new File("Orders");
        if(folder.exists()) {
            // Simple recursive delete could go here,
            // but for safety in this test we'll just leave it.
        }
    }
}