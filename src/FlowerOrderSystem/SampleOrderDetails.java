package src.FlowerOrderSystem;

import javax.swing.*;

public class SampleOrderDetails {
    private JPanel OrderDetailsPnl;
    private JPanel Holder;
    private JPanel Header;
    private JPanel Body;
    private JPanel Footer;
    private JPanel East;
    private JPanel West;
    private JPanel CustomerDetails;
    private JPanel Middle;
    private JPanel GrandTotal;
    private JPanel OrderDetails;
    private JPanel AddOns;
    private JPanel Left;
    private JPanel Right;
    private JPanel North;
    private JPanel South;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JPanel RightAddOn;
    private JTextField addASurprisingElementTextField;
    private JPanel LeftAddOn;
    private JCheckBox handwrittenCardCheckBox;
    private JCheckBox fiyeroChocolateCheckBox;
    private JPanel SampleOrderDetailsPnl;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new SampleOrderDetails().OrderDetailsPnl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
