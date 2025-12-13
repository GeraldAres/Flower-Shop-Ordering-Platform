package src.FlowerOrderSystem;


import src.FlowerOrderSystem.Controllers.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutPanel {
     JPanel checkoutPanel;
    private JPanel container;
    private JPanel header;
    private JPanel center;
    private JPanel left;
    private JPanel Personal;
    private JPanel orderInfo;
    private JPanel OrdersHere;
    private JPanel AddOns;
    private JCheckBox fiyeroChocolateCheckbox;
    private JButton checkoutBtn;
    private JPanel right;
    private JTextArea specialRequest;
    private JPanel PersonalInformation;
    private JLabel totalPrice;
    private Inventory inventory;
    private Order order;
    private Controller controller;
    private User user;

    public static void main (String[] args) {

        JFrame frame = new JFrame("Hiraya Cebu");
        frame.setContentPane(new CheckoutPanel().checkoutPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }

    public void setOrderController(Controller controller){
        this.controller = controller;
        checkoutBtn.setVisible(true);
        checkoutBtn.setEnabled(false);



        checkoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


               /* inventory.updateStock("rose", order.count("rose"));
                inventory.displayInventoryStock();

                inventory.updateStock("lily", order.count("lily"));
                inventory.displayInventoryStock();

                inventory.updateStock("sunflower", order.count("sunflower"));
                inventory.displayInventoryStock();

                inventory.updateStock("tulip", order.count("tulip"));
                inventory.displayInventoryStock();

                inventory.updateStock("carnation", order.count("carnation"));
                inventory.displayInventoryStock();

                inventory.updateStock("daisy", order.count("daisy"));
                inventory.displayInventoryStock();
                    eveyerhitng that ia am praise the lord

                */


            }
        });
    }

    public void displayOrder(User activeUser, Order order) {
        this.user = activeUser;
    this.order = order;
    }
}
