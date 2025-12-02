package src.FlowerOrderSystem;

import java.io.*;

public class SignUp {
    private User user;
    private String successful = "Your Hiraya Cebu account has been created. Please refresh and log in to continue.";
    private String fullName;
    private String email;
    private String contactNum;
    private String userName;
    private String Password;

    public SignUp(String fullName, String emailAddress, String contactNumber, String username, String password, String confirmPassword) throws InvalidInputException{
        this.fullName = fullName;
        this.email = emailAddress;
        this.contactNum = contactNumber;
        this.userName = username;
        this.Password = password;

            if (!password.equals(confirmPassword)) {
                throw new InvalidInputException("Passwords do not match");
            }

        File file = new File("Accounts/accounts.csv");
            if (file.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                        while ((line = br.readLine()) != null) {
                            if (line.startsWith("Name,Email")) {
                                continue;
                            }
                            String[] parts = line.split(",");
                                if (parts.length > 3 && parts[3].equals(userName)) {
                                    throw new InvalidInputException("Username already exists. Please choose a different one.");
                                }
                        }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }

            boolean isNewFile = !file.exists();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                    if (isNewFile) {
                        bw.write("Name,Email,ContactNumber,Username,Password");
                        bw.newLine();
                    } else {
                        bw.newLine();
                    }

                    String newData = fullName + "," + emailAddress + "," + contactNumber + "," + username + "," + password;
                    bw.write(newData);
                } catch (IOException e) {
                    throw new InvalidInputException("Error saving account in the database.");
                }

            File userOrderFolder = new File("Orders/" + username);
                if (!userOrderFolder.exists()) {
                    boolean created = userOrderFolder.mkdirs();
                        if (!created) {
                            System.err.println("Warning: Could not create a folder for " + username);
                        }
                }
        user = new User(fullName, emailAddress, contactNumber, username, password);
    }

    public String getFullName(){
        return fullName;
    }

    public String getEmail(){
        return email;
    }

    public String getContactNum(){
        return contactNum;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword() {
        return Password;
    }

    /*Will be displayed sa dialog box telling the user to refresh */
    public String getSuccessful(){
        return successful;
    }
}
