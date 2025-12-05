package src.FlowerOrderSystem;

import java.io.*;

public class StatusTester {

    public static void main(String[] args) {
        System.out.println("====== STARTING ORDER STATUS TESTER ======");

        try {
            // 1. SETUP: Create a User and an Order
            // We use a specific username to isolate this test in "Orders/StatusTestUser"
            User user = new User(
                    "Status Tester",
                    "tester@example.com",
                    "+63 9171234567",
                    "StatusTestUser",
                    "Pass123!",
                    "Pass123!"
            );

            CheckOut order = new CheckOut(null, user);

            // Fill in some dummy details so the file isn't empty
            order.setModeOfDelivery("Pick-up");
            order.setTotalPrice(100.00);

            // Save the initial order (Should be "Pending" by default)
            order.saveOrder();

            System.out.println("\n--- TEST 1: Check Initial State ---");
            String currentStatus = getStatusFromFile(order);
            if (currentStatus.equals("Pending")) {
                System.out.println("✔ PASS: Initial status is 'Pending'");
            } else {
                System.out.println("❌ FAIL: Expected 'Pending', found '" + currentStatus + "'");
            }


            // 2. TEST VALID CHANGE (Pending -> Ongoing)
            System.out.println("\n--- TEST 2: Change to 'Ongoing' ---");
            boolean result2 = order.changeOrderStatus("Ongoing");

            String fileStatus2 = getStatusFromFile(order);
            if (result2 && fileStatus2.equals("Ongoing")) {
                System.out.println("✔ PASS: Status updated to 'Ongoing' in memory and file.");
            } else {
                System.out.println("❌ FAIL: Update failed. File says: " + fileStatus2);
            }


            // 3. TEST INVALID CHANGE (Try a random word)
            System.out.println("\n--- TEST 3: Try Invalid Status ('Shipping') ---");
            // 'Shipping' is not in your allowed list, so this should return false
            boolean result3 = order.changeOrderStatus("Shipping");

            String fileStatus3 = getStatusFromFile(order);
            if (!result3 && fileStatus3.equals("Ongoing")) {
                System.out.println("✔ PASS: System rejected invalid status. File remains 'Ongoing'.");
            } else {
                System.out.println("❌ FAIL: System allowed invalid status or file changed unexpectedly.");
            }


            // 4. TEST CASE INSENSITIVITY (complete -> Complete)
            System.out.println("\n--- TEST 4: Case Insensitivity ('complete') ---");
            boolean result4 = order.changeOrderStatus("complete"); // Lowercase input

            String fileStatus4 = getStatusFromFile(order);
            if (result4 && fileStatus4.equals("Complete")) {
                System.out.println("✔ PASS: System handled lowercase input. File says 'Complete'.");
            } else {
                System.out.println("❌ FAIL: Update failed. File says: " + fileStatus4);
            }

            // Print final location
            System.out.println("\nTest finished. You can check the file manually at:");
            System.out.println("Orders/StatusTestUser/" + order.getOrderID() + ".txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Helper method to physically read the text file and find the "Order Status:" line.
     * This proves that the saveOrder() method is actually working.
     */
    private static String getStatusFromFile(CheckOut order) {
        String username = order.getUser() != null ? order.getUser().getUsername() : "Guest";
        if (username.equals("default")) username = "Guest";

        File file = new File("Orders/" + username + "/" + order.getOrderID() + ".txt");

        if (!file.exists()) return "FILE_NOT_FOUND";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Order Status:")) {
                    // Extract the value after the colon
                    return line.split(":")[1].trim();
                }
            }
        } catch (IOException e) {
            return "ERROR_READING_FILE";
        }
        return "STATUS_LINE_NOT_FOUND";
    }
}