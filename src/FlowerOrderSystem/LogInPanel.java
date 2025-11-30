package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInPanel {
    JPanel LogInPnl;
    private JPanel BusinessName;
    private JPanel Right;
    private JLabel Welcome;
    private JPanel Left;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton logInButton;
    private JLabel InvalidUsername;
    private JLabel invalidPassword;
    private JButton prevButton;
    private JPanel Holder;
    private JLabel SignUpBtn;
    private JLabel ForgotPasswordBtn;
    private JPanel Log;

    public LogInPanel(JPanel MainPanel, CardLayout cardLayout) {

        ImageIcon image5 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/prev.png");
        Image img5=  image5.getImage().getScaledInstance(66, 29, Image.SCALE_SMOOTH);
        ImageIcon prev = new ImageIcon(img5);
        prevButton.setIcon(prev);
        prevButton.setText("");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainPanel, "FirstPage");
            }
        });

        prevButton.setOpaque(false);
        prevButton.setContentAreaFilled(false);
        prevButton.setBorderPainted(false);
        prevButton.setFocusPainted(false);
        prevButton.setText("");

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainPanel, "Dashboard");
            }
        });

        usernameField.getCaret().setVisible(true);
        passwordField.getCaret().setSelectionVisible(true);
    }

}

