package src.FlowerOrderSystem;

public class NewForm {
    private Guest guest;
    private Order order;


    public NewForm() {
    }

    public void createUser(String name, String emailAddress, String contactNumber) throws InvalidInputException  {
        this.guest = new Guest(name, emailAddress, contactNumber);
    }

    public void createOrder(String type){
        this.order = new Order (type);
    }

    public Order getOrder() {
        return order;
    }

    public Guest getUser() {
        return guest;
    }
}
