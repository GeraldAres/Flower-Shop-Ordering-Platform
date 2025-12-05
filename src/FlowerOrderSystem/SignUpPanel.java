package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUpPanel {
    JPanel SignUpPnl;
    private JPanel BusinessName;
    private JPanel Right;
    private JLabel Welcome;
    private JPanel Left;
    private JTextField fullnameField;
    private JTextField passwordField;
    private JButton createAccountButton;
    private JLabel InvalidUsername;
    private JLabel invalidPassword;
    private JButton prevButton;
    private JPanel Holder;
    private JTextField confirmPasswordField;
    private JLabel ConfirmPassField;
    private JTextField usernameField;
    private JLabel usernameText;
    private JTextField contactField;
    private JLabel ContactNo;
    private JTextField emailField;
    private JLabel email;
    private JLabel LogInBtn;
    private JPanel Log;

    public SignUpPanel(JPanel MainPanel, CardLayout cardLayout) throws InvalidInputException {

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fullnameField.getText();
                String email = emailField.getText();
                String contactNo = contactField.getText();
                String password = passwordField.getText();
                String confirmPassword = confirmPasswordField.getText();
                String username = usernameField.getText();
                User user = new User(name, email, contactNo, password, confirmPassword);
            }
        });



        LogInBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(MainPanel, "LogInPanel");
            }

        });
    }
}

