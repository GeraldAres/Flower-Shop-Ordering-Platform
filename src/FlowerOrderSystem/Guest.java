package src.FlowerOrderSystem;

public class Guest {
    private String name;
    private String emailAddress;
    private String contactNumber;

    public Guest(String name, String emailAddress, String contactNumber) throws InvalidInputException  {
        if (name == null || name.trim().isEmpty()
                || !name.matches("[a-zA-Z .]+")) {
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
        this.name = name;
        this.emailAddress = emailAddress;
        this.contactNumber = contactNumber;

    }

    public String getName() {
        return name;
    }
    public String getAddress() {
        return emailAddress;
    }
    public String getContactNumber() {
        return contactNumber;
    }
}
