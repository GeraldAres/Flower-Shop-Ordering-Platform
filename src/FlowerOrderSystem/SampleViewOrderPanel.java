package src.FlowerOrderSystem;

import javax.swing.*;

public class SampleViewOrderPanel {

    private JPanel SampleViewOrderPnl;
    private JPanel Header;
    private JPanel Holder;
    private JPanel BusinessName;
    private JPanel Body;
    private JPanel North;
    private JPanel West;
    private JPanel South;
    private JPanel East;
    private JPanel Order;
    private JScrollPane Scrikk;
    private JPanel Status1;
    private JPanel Date1;
    private JPanel One;
    private JPanel View1;
    private JPanel Two;
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
