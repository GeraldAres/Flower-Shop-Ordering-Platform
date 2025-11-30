package src.FlowerOrderSystem;

import javax.swing.*;

public class CheckoutPanel {
    private JPanel checkoutPanel;
    private JButton checkOutButton;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton prevButton;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new CheckoutPanel().checkoutPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080 , 1440);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
