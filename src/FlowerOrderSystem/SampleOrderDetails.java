package src.FlowerOrderSystem;

import javax.swing.*;

public class SampleOrderDetails {
    private JPanel OrderDetailsPnl;
    private JPanel Holder;
    private JPanel Header;
    private JPanel Body;
    private JPanel South;
    private JPanel East;
    private JPanel West;
    private JPanel CustomerDetails;
    private JPanel GrandTotal;
    private JPanel OrderDetails;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JPanel SampleOrderDetailsPnl;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new SampleOrderDetails().OrderDetailsPnl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
