package src.FlowerOrderSystem;

public class User {
    private String name;
    private String address;
    private String contactNumber;

    public User(String name, String address, String contactNumber) throws InvalidInputException  {
        if (name == null || name.trim().isEmpty()
                || !name.matches("[a-zA-Z .]+")) {
            throw new InvalidInputException("Invalid name");
        }

        if (address == null || address.trim().isEmpty()
                || !address.matches("[a-zA-Z0-9 ,.-]+")) {
            throw new InvalidInputException("Invalid address");
        }

        if (contactNumber == null || contactNumber.trim().isEmpty()
                ||  !contactNumber.trim().matches("\\+\\d{2} \\d{9,10}")) {
            throw new InvalidInputException("Invalid contact number");
        }
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;

    }

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getContactNumber() {
        return contactNumber;
    }
}
