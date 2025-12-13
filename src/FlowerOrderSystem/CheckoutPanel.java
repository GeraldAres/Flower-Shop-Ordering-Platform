package src.FlowerOrderSystem;


import src.FlowerOrderSystem.Controllers.Controller;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
    private JCheckBox fereroAddOn;
    private JButton checkoutBtn;
    private JPanel right;
    private JTextArea specialRequest;
    private JPanel PersonalInformation;
    private JLabel totalPrice;
    private JLabel customerName;
    private JLabel contactNumber;
    private JLabel email;
    private JPanel orderSummaryPanel;
    private JCheckBox tobleronAddOn;
    private JCheckBox teddyBearAddOn;
    private JCheckBox labubuAddOn;
    private JComboBox delivery;
    private JComboBox payment;
    private JTextField deliveryAddress;
    private JTextField Date;
    private JTextField Receiver;
    private Inventory inventory;
    private Order order;
    private Controller controller;
    private User user;


    public void setOrderController(Controller controller){
        this.controller = controller;
        checkoutBtn.setEnabled(false);
        displayUser();
        displayOrder();


        String modeOfDelivery;
        String modeOfPayment;
        if ((!delivery.getSelectedItem().toString().equals("Select one"))
                && (!payment.getSelectedItem().toString().equals("Select one"))
        ) {
            modeOfDelivery = delivery.getSelectedItem().toString();
            modeOfPayment = payment.getSelectedItem().toString();
            checkoutBtn.setEnabled(true);

        }



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

    public void setDisplay(User activeUser, Order order){
        this.user = activeUser;
        this.order = order;
    }

    public void displayUser(){
        if(user != null){
            customerName.setText(user.getFullName());
            contactNumber.setText(user.getContactNumber());
            email.setText(user.getEmail());
        }
    }

    private boolean alreadyDisplayed(ArrayList<InBloom> displayed, InBloom flower) {
        for (InBloom f : displayed) {
            if (f.getName().equals(flower.getName()) && f.getColor().equals(flower.getColor())) {
                return true;
            }
        }
        return false;
    }


    public void displayOrder() {
        orderSummaryPanel.setLayout(new BoxLayout(orderSummaryPanel, BoxLayout.Y_AXIS));

        if (order != null && orderSummaryPanel != null) {
            orderSummaryPanel.removeAll(); // clears old labels
            ArrayList<InBloom> flowers = order.getFlowers();
            ArrayList<InBloom> displayed = new ArrayList<>(); // track displayed types

            for (InBloom flower : flowers) {
                if (alreadyDisplayed(displayed, flower)) {
                    continue; // skip if already displayed
                }

                // Count quantity of this type
                int count = 0;
                for (InBloom f : flowers) {
                    if (f.getName().equals(flower.getName()) && f.getColor().equals(flower.getColor())) {
                        count++;
                    }
                }

                // Build label text: Name(Color)   Qty   TotalPrice
                String text = String.format("%-54s %5d   %7.2f",
                        flower.getName() + " (" + flower.getColor() + ")",
                        count,
                        count * flower.getPrice());

                JLabel label = new JLabel(text);

                try {
                    Font bellFont = new Font("Bell MT", Font.PLAIN, 20);
                    label.setFont(bellFont);
                    label.setForeground(Color.decode("#561C32"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                orderSummaryPanel.add(label);
                displayed.add(flower); // mark as displayed
            }

            orderSummaryPanel.revalidate();
            orderSummaryPanel.repaint();
        }
    }



}
