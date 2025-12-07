package src.FlowerOrderSystem;

import java.io.IOException;

public class LogInTester {
    /*public static void main(String[] args) {
        System.out.println("====== STARTING LOGIN TESTS ======");

        // --- PRE-REQUISITE: Ensure 'Accounts/accounts.csv' exists ---
        // If you deleted it, run SignUpTester again first!

        // --- TEST 1: Valid Login (Should Success) ---
        // Change "flowerKing" and "pass123" to whatever you actually have in your CSV
        String validUser = "flowerKing";
        String validPass = "pass123";

        System.out.println("\n--- Test 1: Valid Login (" + validUser + ") ---");
        try {
            LogIn login = new LogIn(validUser, validPass);
            User u = login.getUser();

            System.out.println("✔ PASS: " + login.getSuccessMess());
            System.out.println("   -> Logged in as: " + u.getFullName());
            System.out.println("   -> Email: " + u.getEmail());

        } catch (Exception e) {
            System.out.println("❌ FAIL: " + e.getMessage());
        }

        // --- TEST 2: Wrong Password (Should Fail) ---
        System.out.println("\n--- Test 2: Wrong Password ---");
        try {
            new LogIn(validUser, "wrongPassword123");
            System.out.println("❌ FAIL: It allowed a wrong password!");
        } catch (InvalidInputException e) {
            System.out.println("✔ PASS: Caught expected error -> " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- TEST 3: Username Not Found (Should Fail) ---
        System.out.println("\n--- Test 3: Non-existent User ---");
        try {
            new LogIn("ghostUser999", "pass123");
            System.out.println("❌ FAIL: It allowed a non-existent user!");
        } catch (InvalidInputException e) {
            System.out.println("✔ PASS: Caught expected error -> " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

}