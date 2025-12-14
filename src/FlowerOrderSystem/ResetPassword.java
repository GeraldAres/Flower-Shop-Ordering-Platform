package src.FlowerOrderSystem;

import java.io.*;
import java.util.*;

public class ResetPassword {
    private String successMessage = "Password has been successfully changed.";

    public ResetPassword(String username, String email, String newPassword, String confirmPassword) throws InvalidInputException, IOException {
        if (!newPassword.equals(confirmPassword)) {
            throw new InvalidInputException("Passwords do not match.");
        }

        File file = new File("Accounts/accounts.csv");
            if (!file.exists()) {
                throw new InvalidInputException("No accounts found.");
            }

        List<String> fileContent = new ArrayList<>();
        boolean userFound = false;

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                    while ((line = br.readLine()) != null) {
                        if (line.startsWith("Name,Email")) {
                            fileContent.add(line);
                            continue;
                        }

                        if (line.trim().isEmpty()) {
                            continue;
                        }

                        String[] data = line.split(",");
                            if (data.length >= 5 && data[3].equals(username)) {
                                userFound = true;
                                String updatedLine = data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + newPassword;
                                fileContent.add(updatedLine);
                            } else {
                                fileContent.add(line);
                            }
                    }
            }

            if (!userFound) {
                throw new InvalidInputException("Username does not exist.");
            }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String s : fileContent) {
                bw.write(s);
                bw.newLine();
            }
        }
    }

    public String getSuccessMessage() {
        return successMessage;
    }
}