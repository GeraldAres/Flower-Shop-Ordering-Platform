package src.FlowerOrderSystem;

public class NewForm {
    private User user;
    private Order order;

    public User createUser(String name, String address, int contactNumber) {
        this.user = new User(name, address, contactNumber);
        return user;
    }

    public Order createOrder(String type){
        this.order = new Order (type);
        return order;
    }

    public Order getOrder() {
        return order;
    }

    public User getUser() {
        return user;
    }
}
