package src.FlowerOrderSystem;

import src.FlowerOrderSystem.Controllers.UserController;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class LogInPanel {
    JPanel LogInPnl;
    private JPanel BusinessName;
    private JPanel Right;
    private JLabel Welcome;
    private JPanel Left;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton logInButton;
    private JLabel invalidPassword;
    private JButton prevButton;
    private JPanel Holder;
    private JLabel SignUpBtn;
    private JLabel ForgotPasswordBtn;
    private JPanel Log;
    private UserController userController;

    public LogInPanel() {
        ImageIcon image5 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/prev.png");
        Image img5=  image5.getImage().getScaledInstance(66, 29, Image.SCALE_SMOOTH);
        ImageIcon prev = new ImageIcon(img5);
        prevButton.setIcon(prev);
        prevButton.setText("");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        prevButton.setOpaque(false);
        prevButton.setContentAreaFilled(false);
        prevButton.setBorderPainted(false);
        prevButton.setFocusPainted(false);
        prevButton.setText("");


        usernameField.getCaret().setVisible(true);
        passwordField.getCaret().setSelectionVisible(true);
    }
    public void setController(UserController userController) {
        this.userController = userController;
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                try {
                    userController.logInValidation(username, password);
                } catch (InvalidInputException ex) {
                    invalidPassword.setVisible(true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);

                }
            }
        });

        SignUpBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    userController.userActions("SignUp");
                } catch (InvalidInputException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
    }

}

