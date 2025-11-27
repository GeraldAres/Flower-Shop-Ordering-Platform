package src.FlowerOrderSystem;

import javax.swing.*;

public class SignInPanel {
    private JPanel SignInPanel;
    private JPanel BusinessName;
    private JPanel Right;
    private JLabel Welcome;
    private JPanel Left;
    private JTextField username;
    private JTextField password;
    private JButton logInButton;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new SignInPanel().SignInPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
