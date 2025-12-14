package src.FlowerOrderSystem;

import javax.swing.*;

public class OrderDetails {
    private JPanel OrderDetailsPnl;
    private JPanel container;
    private JPanel header;
    private JPanel center;
    private JPanel left;
    private JPanel Personal;
    private JPanel orderInfo;
    private JPanel OrdersHere;
    private JPanel PersonalInformation;
    private JLabel customerName;
    private JLabel contactNumber;
    private JLabel email;
    private JPanel AddOns;
    private JLabel fereroPrice;
    private JLabel labubuPrice;
    private JLabel tobleronPrice;
    private JLabel teddyBearPrice;
    private JPanel orderSummaryPanel;
    private JPanel right;
    private JTextArea specialRequest;
    private JLabel totalPrice;
    private JButton checkoutBtn;
    private JPanel SampleOrderDetailsPnl;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new OrderDetails().OrderDetailsPnl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
