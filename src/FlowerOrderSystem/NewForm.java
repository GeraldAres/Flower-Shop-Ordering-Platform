package src.FlowerOrderSystem;

public class NewForm {
    private User user;
    private Order order;
    public NewForm() {
    }

    public void createUser(String name, String emailAddress, String contactNumber) throws InvalidInputException  {
        this.user = new Guest(name, emailAddress, contactNumber);
    }

    public void createUser(String name, String emailAddress, String contactNumber, String username, String password, String confirmPassword) throws InvalidInputException  {
        this.user = new User(name, emailAddress, contactNumber, username, password, confirmPassword);
    }


    public void createOrder(String type){
        this.order = new Order (type);
    }

    public Order getOrder() {
        return order;
    }

    public User getUser() {
        return user;
    }
}
