package src.FlowerOrderSystem;

import src.FlowerOrderSystem.Controllers.CheckoutController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;

public class CheckoutPanel {

    JPanel checkoutPanel;

    private JButton checkoutBtn;
    private JComboBox<String> delivery;
    private JComboBox<String> payment;
    private JTextField deliveryAddress;
    private JTextField dateField;
    private JTextField Receiver;

    private JLabel totalPrice;
    private JLabel customerName;
    private JLabel contactNumber;
    private JLabel email;

    private JPanel orderSummaryPanel;
    private JLabel fereroPrice;
    private JLabel tobleronPrice;
    private JLabel teddyBearPrice;
    private JLabel labubuPrice;
    private JCheckBox fereroAddOn;
    private JCheckBox tobleronAddOn;
    private JCheckBox teddyBearAddOn;
    private JCheckBox labubuAddOn;

    private CheckoutController controller;
    private Order order;
    private User user;

    /* ==============================
       CONTROLLER SETUP
       ============================== */

    public void setOrderController(CheckoutController controller) {
        this.controller = controller;

        checkoutBtn.setEnabled(false);

        customerName.setText(controller.getName());
        contactNumber.setText(controller.getNumber());
        email.setText(controller.getEmail());

        displayOrder();
        attachListeners();
        revalidateCheckout();
    }

    public void setDisplay(User activeUser, Order order) {
        this.user = activeUser;
        this.order = order;
    }


    private void revalidateCheckout() {
        try {
            controller.validate(
                    delivery.getSelectedItem().toString(),
                    payment.getSelectedItem().toString(),
                    dateField.getText(),
                    deliveryAddress.getText(),
                    Receiver.getText()
            );
            checkoutBtn.setEnabled(true);
        } catch (IllegalArgumentException ex) {
            checkoutBtn.setEnabled(false);
        }
    }


    private void attachListeners() {
        DocumentListener docListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                revalidateCheckout();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                revalidateCheckout();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                revalidateCheckout();
            }
        };

        dateField.getDocument().addDocumentListener(docListener);
        Receiver.getDocument().addDocumentListener(docListener);
        deliveryAddress.getDocument().addDocumentListener(docListener);

        delivery.addActionListener(e -> revalidateCheckout());
        payment.addActionListener(e -> revalidateCheckout());

        checkoutBtn.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.processCheckout(delivery.getSelectedItem().toString(), payment.getSelectedItem().toString(),  dateField.getText(),  deliveryAddress.getText(),  Receiver.getText(), getAddOns(), Double.parseDouble(totalPrice.getText()));
            }
        });

    }

    public ArrayList<String> getAddOns(){
        ArrayList<String> addOns = new ArrayList<>();
        if (teddyBearAddOn.isSelected()){
            addOns.add("TeddyBear");
        }
        if (labubuAddOn.isSelected()){
            addOns.add("Labubu");
        }
        if(tobleronAddOn.isSelected()){
            addOns.add("Tobleron");
        }
        if(teddyBearAddOn.isSelected()){
            addOns.add("TeddyBear");
        }
        return addOns;
    }

    /* ==============================
       ORDER SUMMARY
       ============================== */

    private boolean alreadyDisplayed(ArrayList<InBloom> displayed, InBloom flower) {
        for (InBloom f : displayed) {
            if (f.getName().equals(flower.getName())
                    && f.getColor().equals(flower.getColor())) {
                return true;
            }
        }
        return false;
    }

    public void displayOrder() {
        orderSummaryPanel.setLayout(new BoxLayout(orderSummaryPanel, BoxLayout.Y_AXIS));

        if (order == null) return;

        orderSummaryPanel.removeAll();

        ArrayList<InBloom> flowers = order.getFlowers();
        ArrayList<InBloom> displayed = new ArrayList<>();

        for (InBloom flower : flowers) {

            if (alreadyDisplayed(displayed, flower)) continue;

            int count = 0;
            for (InBloom f : flowers) {
                if (f.getName().equals(flower.getName())
                        && f.getColor().equals(flower.getColor())) {
                    count++;
                }
            }

            String text = String.format(
                    "%-54s %5d   %7.2f",
                    flower.getName() + " (" + flower.getColor() + ")",
                    count,
                    count * flower.getPrice()
            );

            JLabel label = new JLabel(text);
            label.setFont(new Font("Bell MT", Font.PLAIN, 20));
            label.setForeground(Color.decode("#561C32"));

            orderSummaryPanel.add(label);
            displayed.add(flower);
        }

        totalPrice.setText("P " + order.getOrderPrice() + "0");
        orderSummaryPanel.revalidate();
        orderSummaryPanel.repaint();
    }
}
