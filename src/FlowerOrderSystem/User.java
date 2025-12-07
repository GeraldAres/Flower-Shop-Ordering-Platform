package src.FlowerOrderSystem;
import src.FlowerOrderSystem.InvalidInputException;

import java.util.ArrayList;

public class User {
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String contactNumber;
    private ArrayList<CheckOut> orders;
    public User(){

    }
    public User(String fullName, String emailAddress, String contactNumber) throws InvalidInputException, InvalidInputException.InvalidEmail, InvalidInputException.InvalidName, InvalidInputException.InvalidPhone {
        validateUserInfo(fullName, emailAddress, contactNumber);
        this.fullName = fullName;
        this.email = emailAddress;
        this.contactNumber = contactNumber;
        this.username = "default";
        this.password = "default";
    }

    public User validateSignUp (String fullName, String emailAddress, String contactNumber, String username, String password, String confirmPassword) throws InvalidInputException, InvalidInputException.InvalidEmail, InvalidInputException.InvalidName, InvalidInputException.InvalidPhone, InvalidInputException.PasswordMismatch, InvalidInputException.WeakPassword {
        validateUserInfo(fullName, emailAddress, contactNumber);
        if (username == null || username.trim().isEmpty()
                || !username.matches("^[A-Za-z0-9_]{3,16}$")) {
            throw new InvalidInputException("Invalid username");
        }
        if (password == null || password.trim().isEmpty()
                || !password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
            throw new InvalidInputException.WeakPassword("Password must be 8+ characters with uppercase, lowercase, number, and special symbol.");
        }
        if (!password.equals(confirmPassword)) {
            throw new InvalidInputException.PasswordMismatch("Passwords do not match");
        }
        this.fullName = fullName;
        this.email = emailAddress;
        this.contactNumber = contactNumber;
        this.username = username;
        this.password = password;
        return this;
    }

    public User(String fullName, String email, String contactNumber, String username, String password) {
        this.fullName = fullName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.username = username;
        this.password = password;
    }


    public void validateUserInfo(String fullName, String email, String contactNumber) throws InvalidInputException, InvalidInputException.InvalidName, InvalidInputException.InvalidEmail, InvalidInputException.InvalidPhone {
        if (fullName == null || fullName.trim().isEmpty()
                || !fullName.matches("[a-zA-Z .]+")) {
            throw new InvalidInputException.InvalidName("Invalid name");
        }
        if (email == null || email.trim().isEmpty()
                || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new InvalidInputException.InvalidEmail("Invalid email address");
        }
        if (contactNumber == null || contactNumber.trim().isEmpty()
                || !contactNumber.trim().matches("\\+\\d{11,12}")) {
            throw new InvalidInputException.InvalidPhone("Invalid contact number");
        }
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void addOrder(CheckOut order) {
        orders.add(order);
    }

    public ArrayList<CheckOut> getOrders() {
        return orders;
    }

    public void removeOrder(String orderID) {
        orders.removeIf(order -> order.getOrderID().equals(orderID));
    }
}
