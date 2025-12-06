package src.FlowerOrderSystem;

public class Guest extends User {
    public Guest(String name, String emailAddress, String contactNumber) throws InvalidInputException  {
        super(name, emailAddress, contactNumber);
    }

    public Guest(){

    }
}
