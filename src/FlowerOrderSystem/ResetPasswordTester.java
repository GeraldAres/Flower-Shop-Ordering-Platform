package src.FlowerOrderSystem;

import java.io.*;

public class ResetPasswordTester {
    public static void main(String[] args) {
      /* System.out.println("====== STARTING PASSWORD RESET TESTS ======");

        // Pre-requisite: Make sure 'flowerKing' exists (from SignUpTester)
        String targetUser = "Fatima";
        String targetEmail = "king@test.com"; // Must match what you signed up with

        // --- TEST 1: Successful Reset ---
        System.out.println("\n--- Test 1: Resetting Password for " + targetUser + " ---");
        try {
            // Changing password to "newSecret999"
            ResetPassword reset = new ResetPassword(targetUser, targetEmail, "newSecret999", "newSecret999");
            System.out.println("✔ PASS: " + reset.getSuccessMessage());
        } catch (Exception e) {
            System.out.println("❌ FAIL: " + e.getMessage());
            e.printStackTrace();
        }

        // --- TEST 2: Verify Login with NEW Password ---
        System.out.println("\n--- Test 2: Logging in with NEW Password ---");
        try {
            new LogIn(targetUser, "newSecret999");
            System.out.println("✔ PASS: Login successful with new password.");
        } catch (Exception e) {
            System.out.println("❌ FAIL: Could not login with new password.");
        }

        // --- TEST 3: Wrong Email (Should Fail) ---
        System.out.println("\n--- Test 3: Hacking attempt (Wrong Email) ---");
        try {
            new ResetPassword(targetUser, "hacker@evil.com", "hacked", "hacked");
            System.out.println("❌ FAIL: System allowed reset with wrong email!");
        } catch (InvalidInputException e) {
            System.out.println("✔ PASS: Caught expected error -> " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

       */
    }

}