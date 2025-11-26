package src.FlowerOrderSystem;
import src.FlowerOrderSystem.InvalidInputException;

import java.util.ArrayList;

public class User {
    private final String fullName;
    private String username;
    private String password;
    private String email;
    private String contactNumber;
    private ArrayList<CheckOut> Orders;

    public User(String fullName, String emailAddress, String contactNumber) throws InvalidInputException {
        if (fullName == null || fullName.trim().isEmpty()
                || !fullName.matches("[a-zA-Z .]+")) {
            throw new InvalidInputException("Invalid name");
        }
        if (emailAddress == null || emailAddress.trim().isEmpty()
                || !emailAddress.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new InvalidInputException("Invalid email address");
        }
        if (contactNumber == null || contactNumber.trim().isEmpty()
                ||  !contactNumber.trim().matches("\\+\\d{2} \\d{9,10}")) {
            throw new InvalidInputException("Invalid contact number");
        }
        this.fullName = fullName;
        this.email = emailAddress;
        this.contactNumber = contactNumber;
        this.username = "default";
        this.password = "default";
    }

    public User (String fullName, String emailAddress, String contactNumber, String username, String password, String confirmPassword) throws InvalidInputException {
        if (fullName == null || fullName.trim().isEmpty()
                || !fullName.matches("[a-zA-Z .]+")) {
            throw new InvalidInputException("Invalid name");
        }
        if (emailAddress == null || emailAddress.trim().isEmpty()
                || !emailAddress.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new InvalidInputException("Invalid email address");
        }
        if (contactNumber == null || contactNumber.trim().isEmpty()
                ||  !contactNumber.trim().matches("\\+\\d{2} \\d{9,10}")) {
            throw new InvalidInputException("Invalid contact number");
        }
        if (username == null || username.trim().isEmpty()
                || !username.matches("^[A-Za-z0-9_]{3,16}$")) {
            throw new InvalidInputException("Invalid username");
        }
        if (password == null || password.trim().isEmpty()
                || !password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
            throw new InvalidInputException("Invalid password");
        }
        if (!password.equals(confirmPassword)) {
            throw new InvalidInputException("Passwords do not match");
        }
        this.fullName = fullName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.username = username;
        this.password = password;
        Orders = new ArrayList<>();
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
        Orders.add(order);
    }

    public ArrayList<CheckOut> getOrders() {
        return Orders;
    }

    public void removeOrder(String orderID) {
        for (CheckOut order : Orders) {
            if (order.getOrderID().equals(orderID)){
                Orders.remove(order);
            }
        }
    }
}
