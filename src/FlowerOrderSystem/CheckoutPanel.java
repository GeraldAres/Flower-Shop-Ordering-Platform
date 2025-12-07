package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutPanel {
    JPanel checkoutPanel;
    private JPanel container;
    private JPanel header;
    private JPanel left;
    private JPanel right;
    private JPanel center;
    private JLabel customerName;
    private JLabel custoemrAddress;
    private JLabel customerGmail;
    private JCheckBox fiyeroChocolateCheckbox;
    private JLabel totalPrice;
    private JButton checkoutBtn;
    private JPanel top;
    private JComboBox deliveryCombobox;
    private JComboBox paymentCombobox;
    private JTextArea specialInstructions;
    private JPanel customerDetails;

    private Inventory inventory;
    private Order order;

    public CheckoutPanel(Inventory inventory, Order order){


        JLabel label = new JLabel("casidey");

        label.setFont(label.getFont().deriveFont(18f));
        label.setForeground(new Color(0x561C32));
        customerDetails.add(label);

        this.inventory = inventory;
        this.order = order;

        totalPrice.setText("$" + order.getOrderPrice() + "");

        checkoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventory.updateStock("rose", order.count("rose"));
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


            }
        });


    }





//    public static void main(String[] args) {
//        new CheckoutPanel();
//    }
}
