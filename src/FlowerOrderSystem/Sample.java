package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;

public class Sample {
    private JPanel Sample;
    private JPanel Header;
    private JPanel Body;
    private JScrollPane Scrikk;
    private JPanel Holder2;
    private JButton newOrderButton;
    private JButton myOrdersBtn;
    private JButton availableFlowersbtn;
    private JButton settingsBtn;
    private JLabel ImageHolder;
    private JLabel LogOut;

    public Sample() {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new Sample().Sample);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setLocationRelativeTo(null); // center window
        frame.setVisible(true);
    }
}
