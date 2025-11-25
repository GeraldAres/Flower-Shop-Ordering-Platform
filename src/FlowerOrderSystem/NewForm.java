package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;

public class NewForm {
    private User user;
    private Order order;


    public NewForm() {
    }

    public void createUser(String name, String emailAddress, String contactNumber) throws InvalidInputException  {
        this.user = new User(name, emailAddress, contactNumber);
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
