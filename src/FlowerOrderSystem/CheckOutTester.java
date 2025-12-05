package src.FlowerOrderSystem;

import java.io.File;

public class CheckOutTester {
    public static void main(String[] args) {
        System.out.println("====== STARTING CHECKOUT SAVE LOGIC TEST ======");

        // --- TEST 1: GUEST USER (Should go to Orders/Guest) ---
        System.out.println("\n--- Test 1: Guest User (John Doe) ---");
        try {
            // 1. Create a Guest User (using the 3-parameter constructor)
            // Note: The User class automatically sets username to "default" internally.
            User guestUser = new User(
                    "John Doe",
                    "john.guest@example.com",
                    "+63 9171234567" // Must match your regex
            );

            // 2. Create the Order
            CheckOut guestOrder = new CheckOut(null, guestUser);

            // 3. Fill in dummy details so the file isn't empty
            guestOrder.setTotalPrice(1500.50);
            guestOrder.setModeOfDelivery("Pick-up");
            guestOrder.setModeOfPayment("Cash");

            // 4. Save Logic
            guestOrder.saveOrder(); // Should detect "default" username -> "Guest" folder

            // 5. Verify Verification
            String expectedPath = "Orders/Guest/" + guestOrder.getOrderID() + ".txt";
            verifyFileExists(expectedPath);

        } catch (Exception e) {
            System.out.println("❌ TEST 1 FAILED: " + e.getMessage());
            e.printStackTrace();
        }


        // --- TEST 2: REGISTERED USER (Should go to Orders/alice01) ---
        System.out.println("\n--- Test 2: Registered User (Alice) ---");
        try {
            // 1. Create a Registered User (using the full constructor)
            User regUser = new User(
                    "Alice Wonderland",
                    "alice@wonderland.com",
                    "+63 9181234567",
                    "alice01",
                    "Pass123!", // Must match password regex
                    "Pass123!"
            );

            // 2. Create the Order
            CheckOut regOrder = new CheckOut(null, regUser);

            // 3. Fill in dummy details
            regOrder.setTotalPrice(3000.00);
            regOrder.setModeOfDelivery("Delivery");
            regOrder.setAddressOfDelivery("Cebu City");
            regOrder.setModeOfPayment("GCash");

            // 4. Save Logic
            regOrder.saveOrder(); // Should detect "alice01" -> "alice01" folder

            // 5. Verification
            String expectedPath = "Orders/alice01/" + regOrder.getOrderID() + ".txt";
            verifyFileExists(expectedPath);

        } catch (Exception e) {
            System.out.println("❌ TEST 2 FAILED: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Helper method to check if the file was actually created
    private static void verifyFileExists(String path) {
        File file = new File(path);
        if (file.exists()) {
            System.out.println("✔ SUCCESS: File created at -> " + file.getPath());
            System.out.println("  (Absolute Path: " + file.getAbsolutePath() + ")");
        } else {
            System.out.println("❌ FAILURE: File NOT found at -> " + path);
        }
    }
}