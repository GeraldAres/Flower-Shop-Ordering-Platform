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
    private JPanel container;
    private JPanel header;
    private JPanel center;
    private JPanel left;
    private JPanel right;
    private JPanel Personal;
    private JPanel orderInfo;
    private JPanel AddOns;
    private JPanel OrdersHere;
    private JPanel PersonalInformation;
    private JTextArea specialRequest;
    private double base;
    private CheckoutController controller;
    private Order order;
    private User user;
    private ArrayList<String> addOns = new ArrayList<>();

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

        base = controller.getOrderTotalPrice();

        teddyBearAddOn.addActionListener(e -> updateTotal());
        tobleronAddOn.addActionListener(e -> updateTotal());
        fereroAddOn.addActionListener(e -> updateTotal());
        labubuAddOn.addActionListener(e -> updateTotal());



        checkoutBtn.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.processCheckout(delivery.getSelectedItem().toString(), payment.getSelectedItem().toString(),  dateField.getText(),  deliveryAddress.getText(),
                            Receiver.getText(), getAddOns(), Double.parseDouble(totalPrice.getText()),specialRequest.getText());
                } catch (InvalidInputException.PaymentFailedException ex) {
                    JDialog dialog = new JDialog((JFrame) null, "Info", true); // true = modal
                    dialog.setSize(350, 150);
                    dialog.setLayout(new BorderLayout());

                    JOptionPane.showMessageDialog(dialog, ex.getMessage(), "Uh Oh!", JOptionPane.ERROR_MESSAGE);
                } catch (InvalidInputException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }

    public ArrayList<String> getAddOns() {
        return addOns;
    }

    /* ==============================
       ORDER SUMMARY
       ============================== */
    public void displayOrder() {
        orderSummaryPanel.setLayout(new BoxLayout(orderSummaryPanel, BoxLayout.Y_AXIS));
        orderSummaryPanel.removeAll();

        ImageIcon image1 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/checkoutBtn.png");
        Image img1 =  image1.getImage().getScaledInstance(110, 35, Image.SCALE_SMOOTH);
        ImageIcon Checkoutbtn = new ImageIcon(img1);
        checkoutBtn.setIcon(Checkoutbtn);
        checkoutBtn.setText("");
        checkoutBtn.setOpaque(false);
        checkoutBtn.setContentAreaFilled(false);
        checkoutBtn.setBorderPainted(false);
        checkoutBtn.setFocusPainted(false);
        checkoutBtn.setText("");


        ArrayList<String> lines = controller.getOrderSummaryLines(); // only plain Strings

        for (String text : lines) {
            JLabel label = new JLabel(text);
            label.setFont(new Font("Bell MT", Font.PLAIN, 20));
            label.setForeground(Color.decode("#561C32"));
            orderSummaryPanel.add(label);
        }

        totalPrice.setText( String.format("%.2f", controller.getOrderTotalPrice()));
        orderSummaryPanel.revalidate();
        orderSummaryPanel.repaint();
    }
    private void updateTotal() {
        double newTotal = base;

        // Clear the list first to rebuild it based on current selections
       if(!addOns.isEmpty()){
           addOns.clear();
       }

        if (teddyBearAddOn.isSelected()) {
            addOns.add("Teddy");
            newTotal += 800;
        }

        if (tobleronAddOn.isSelected()) {
            addOns.add("Tobleron");
            newTotal += 500;
        }

        if (fereroAddOn.isSelected()) {
            addOns.add("Ferrero");
            newTotal += 300;
        }

        if (labubuAddOn.isSelected()) {
            addOns.add("Labubu");
            newTotal += 2400;
        }

        // Update the totalPrice label
        totalPrice.setText(String.format("%.2f", newTotal));
    }


}
