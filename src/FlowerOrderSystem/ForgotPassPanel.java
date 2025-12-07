package src.FlowerOrderSystem;

import javax.swing.*;

public class ForgotPassPanel {
    private JPanel ForgotPassPnl;
    private JPanel Holder;
    private JPanel BusinessName;
    private JPanel Left;
    private JTextField usernameField;
    private JButton confirmButton;
    private JLabel SignUpBtn;
    private JLabel InvalidUsername;
    private JLabel invalidPassword;
    private JPasswordField passwordField;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new ForgotPassPanel().ForgotPassPnl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }
}
