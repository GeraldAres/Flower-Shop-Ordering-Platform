package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;

public class SampleViewOrderPanel {

    private JPanel SampleViewOrderPnl;
    private JPanel Header;
    private JPanel Holder;
    private JPanel BusinessName;
    private JScrollPane Scroll;
    private JLabel LeftImg;
    private JLabel RightImg;

    public SampleViewOrderPanel(){

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new SampleViewOrderPanel().SampleViewOrderPnl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
