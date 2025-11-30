package src.FlowerOrderSystem;

import javax.swing.*;

public class CheckoutPanel {
    private JPanel checkoutPanel;
    private JButton checkOutButton;
    private JComboBox modeOfDelivery;
    private JButton prevButton;
    private JRadioButton ferreroRadioButton;
    private JComboBox modeOfPayment;
    private JLabel contactNumber;
    private JLabel dateToDeliver;
    private JLabel customerName;
    private JLabel address;
    private JLabel gmail;
    private JPanel orderDetails;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new CheckoutPanel().checkoutPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080 , 1440);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
