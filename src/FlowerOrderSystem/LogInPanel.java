package src.FlowerOrderSystem;

import javax.swing.*;

public class LogInPanel {
    JPanel LogInPnl;
    private JPanel BusinessName;
    private JPanel Right;
    private JLabel Welcome;
    private JPanel Left;
    private JTextField username;
    private JTextField password;
    private JButton logInButton;
    private JLabel InvalidUsername;
    private JLabel invalidPassword;
    private JButton prevButton;
    private JPanel Log;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new LogInPanel().LogInPnl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}

