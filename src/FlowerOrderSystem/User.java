package src.FlowerOrderSystem;
import src.FlowerOrderSystem.InvalidInputException;
public class User {
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String contactNumber;

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
        this.email = email;
        this.contactNumber = contactNumber;
        this.username = "default";
        this.password = "default";
    }

    public User (String fullName, String emailAddress, String contactNumber, String username, String password) throws InvalidInputException {
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
        this.email = email;
        this.contactNumber = contactNumber;
        this.username = username;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
}
