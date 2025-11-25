package src.FlowerOrderSystem;

public class User {
    private String name;
    private String address;
    private int contactNumber;

    public User(String name, String address, int contactNumber)  {
        try{
            this.name = name;
            this.address = address;
            this.contactNumber = contactNumber;
        } catch(Exception e){
            /* display exception message to user*/
        }
    }

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public int getContactNumber() {
        return contactNumber;
    }
}
