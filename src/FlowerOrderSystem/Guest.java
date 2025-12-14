package src.FlowerOrderSystem;

public class Guest extends User {
    public   Guest(String name, String emailAddress, String contactNumber) throws InvalidInputException, InvalidInputException.InvalidEmail, InvalidInputException.InvalidName, InvalidInputException.InvalidPhone {
        super(name, emailAddress, contactNumber);

    }

    public Guest(){

    }
}
