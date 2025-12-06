package src.FlowerOrderSystem;

import java.io.*;

public class SignUpTester {
    /*
    public static void main(String[] args) {
        System.out.println("====== STARTING SIGN UP & FOLDER CREATION TEST ======");

        // --- TEST 1: First User (Should create CSV + Header + User Folder) ---
        String user1 = "Fatima";
        System.out.println("\n--- Test 1: Creating First User (" + user1 + ") ---");
        try {
            SignUp sign1 = new SignUp(
                    "Fatima",
                    "king@test.com",
                    "09170000001",
                    user1,
                    "pass123",
                    "pass123"
            );
            System.out.println("SignUp Logic: " + sign1.getSuccessful());

            // VERIFY FOLDER CREATION
            File folder1 = new File("Orders/" + user1);
            if (folder1.exists() && folder1.isDirectory()) {
                System.out.println("✔ PASS: Folder 'Orders/" + user1 + "' was created.");
            } else {
                System.out.println("❌ FAIL: Folder 'Orders/" + user1 + "' was NOT created.");
            }

        } catch (Exception e) {
            System.out.println("FAILED with Exception: " + e.getMessage());
            e.printStackTrace();
        }


        // --- TEST 2: Second User (Should Append CSV + Create New Folder) ---
        String user2 = "roseLover";
        System.out.println("\n--- Test 2: Creating Second User (" + user2 + ") ---");
        try {
            SignUp sign2 = new SignUp(
                    "Rose Tyler",
                    "rose@test.com",
                    "09170000002",
                    user2,
                    "secret",
                    "secret"
            );
            System.out.println("SignUp Logic: " + sign2.getSuccessful());

            // VERIFY FOLDER CREATION
            File folder2 = new File("Orders/" + user2);
            if (folder2.exists() && folder2.isDirectory()) {
                System.out.println("✔ PASS: Folder 'Orders/" + user2 + "' was created.");
            } else {
                System.out.println("❌ FAIL: Folder 'Orders/" + user2 + "' was NOT created.");
            }

        } catch (Exception e) {
            System.out.println("FAILED with Exception: " + e.getMessage());
        }


        // --- TEST 3: Duplicate User (Should NOT overwrite folder or CSV) ---
        System.out.println("\n--- Test 3: Duplicate Check (" + user1 + ") ---");
        try {
            new SignUp(
                    "Imposter King",
                    "fake@test.com",
                    "09999999999",
                    user1, // Trying to use "flowerKing" again
                    "pass123",
                    "pass123"
            );
            System.out.println("❌ FAIL: It allowed a duplicate user!");
        } catch (InvalidInputException e) {
            System.out.println("✔ PASS: Caught expected error -> " + e.getMessage());
        }


        // --- FINAL CHECK: READ THE CSV FILE ---
        System.out.println("\n====== VERIFYING CSV CONTENT ======");
        File file = new File("Accounts/accounts.csv");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                int lineCount = 0;
                while ((line = br.readLine()) != null) {
                    System.out.println("[" + (++lineCount) + "] " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error: Accounts/accounts.csv was not created.");
        }
    }

     */
}