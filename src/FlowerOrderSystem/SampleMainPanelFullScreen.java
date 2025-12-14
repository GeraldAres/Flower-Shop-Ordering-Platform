package src.FlowerOrderSystem;

import javax.swing.*;

public class SampleMainPanelFullScreen {
    private JPanel FirstPage;
    private JLabel Logo;
    private JButton btnGuest;
    private JButton btnLogIn;
    private JLabel ImageHolder2;
    private JLabel ImageHolder;
    private JPanel MainPanelFullScreen;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new SampleMainPanelFullScreen().MainPanelFullScreen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
