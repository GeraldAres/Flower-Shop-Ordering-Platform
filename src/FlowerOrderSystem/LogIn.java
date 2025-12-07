package src.FlowerOrderSystem;

import java.io.*;

public class LogIn {
    private User user;
    private final String successMess = "Login successful! Welcome Back!";

    public User validateLogIn (String username, String password) throws IOException, InvalidInputException {
        File file  = new File("Accounts/accounts.csv");
            if (!file.exists()) {
                throw new InvalidInputException("No accounts database found. Please sign up first.");
            }
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                        while ((line = br.readLine()) != null) {
                            if (line.startsWith("Name,Email")) {
                                continue;
                            }

                            String[] data = line.split(",");
                                if (data.length > 5) {
                                    continue;
                                }

                                String storedUserName = data[3].trim();
                                String storedPassword = data[4].trim();
                                    if (storedUserName.equals(username) && storedPassword.equals(password)) {
                                        this.user = new User(data[0], data[1], data[2], data[3], data[4]);
                                        return user;
                                    }
                        }
                }


                throw new InvalidInputException("Invalid username or password.");

    }

    public User getUser() {
        return user;
    }

    public String getSuccessMess() {
        return successMess;
    }
}
