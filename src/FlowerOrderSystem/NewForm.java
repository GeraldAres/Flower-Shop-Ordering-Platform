package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;

public class NewForm {
    private User user;
    private Order order;
    private final JPanel mainPanel;
    private final CardLayout layout;

    public NewForm(JPanel mainPanel, CardLayout layout) {
        this.mainPanel = mainPanel;
        this.layout = layout;
    }

    public void createUser(String name, String emailAddress, String contactNumber) throws InvalidInputException  {
        this.user = new User(name, emailAddress, contactNumber);
    }

    public void createOrder(String type){
        this.order = new Order (type);
        if (type.equals("Stem")) {
            layout.show(mainPanel, "StemPanel");
        }
        if (type.equals("Bouquet")) {
            layout.show(mainPanel, "BouquetPanel");
        }

    }

    public Order getOrder() {
        return order;
    }

    public User getUser() {
        return user;
    }
}
