package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;

public class ForgotPassPanel {
    JPanel ForgotPassPnl;
    private JPanel Holder;
    private JPanel BusinessName;
    private JPanel Right;
    private JLabel Welcome;
    private JButton prevButton;
    private JPanel Left;
    private JTextField newPasswordField;
    private JButton confirmButton;
    private JLabel weakPassword;
    private JLabel passwordMismatch;
    private JPasswordField confirmPasswordFIeld;
    private JTextField usernameFiel;
    private JLabel invalidUsername;

    public ForgotPassPanel() {
        ImageIcon image5 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/prev.png");
        Image img5=  image5.getImage().getScaledInstance(66, 29, Image.SCALE_SMOOTH);
        ImageIcon prev = new ImageIcon(img5);
        prevButton.setIcon(prev);
        prevButton.setText("");
        prevButton.setOpaque(false);
        prevButton.setContentAreaFilled(false);
        prevButton.setBorderPainted(false);
        prevButton.setFocusPainted(false);
        prevButton.setText("");
    }

}
