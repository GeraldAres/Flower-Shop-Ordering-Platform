package src.FlowerOrderSystem;

import src.FlowerOrderSystem.Controllers.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class SignUpPanel {
    JPanel SignUpPnl;
    private JPanel BusinessName;
    private JPanel Right;
    private JLabel Welcome;
    private JPanel Left;
    private JTextField fullnameField;
    private JTextField passwordField;
    private JButton createAccountButton;
    private JLabel invalidUsername;
    private JLabel passwordMismatch;
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
    private JLabel invalidNameField;
    private JLabel invalidEmail;
    private JLabel invalidNumber;
    private JLabel weakPassword;
    private JPanel Log;
    private UserController userController;

    public SignUpPanel() throws InvalidInputException {
        invalidNameField.setVisible(false);
        invalidEmail.setVisible(false);
        invalidNumber.setVisible(false);
        invalidUsername.setVisible(false);
        passwordMismatch.setVisible(false);
        weakPassword.setVisible(false);

        ImageIcon image = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/signUp.png");
        Image img1 =  image.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        ImageIcon login = new ImageIcon(img1);
        createAccountButton.setIcon(login);
        createAccountButton.setText("");
        createAccountButton.setOpaque(false);
        createAccountButton.setContentAreaFilled(false);
        createAccountButton.setBorderPainted(false);
        createAccountButton.setFocusPainted(false);
        createAccountButton.setText("");


        fullnameField.setText("");
        emailField.setText("");
        contactField.setText("+63");
        usernameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        prevButton.setOpaque(false);
        prevButton.setContentAreaFilled(false);
        prevButton.setBorderPainted(false);
        prevButton.setFocusPainted(false);
        prevButton.setText("");

        ImageIcon image5 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/prev.png");
        Image img5=  image5.getImage().getScaledInstance(66, 29, Image.SCALE_SMOOTH);
        ImageIcon prev = new ImageIcon(img5);
        prevButton.setIcon(prev);
        prevButton.setText("");
    }

    public void setController(UserController userController) {
        this.userController = userController;

        fullnameField.setText("");
        emailField.setText("");
        contactField.setText("+63");
        usernameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    userController.userActions("prev");
                } catch (InvalidInputException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        LogInBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    userController.userActions("Regular");
                } catch (InvalidInputException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fullnameField.getText();
                String email = emailField.getText();
                String contactNo = contactField.getText();
                String password = passwordField.getText();
                String confirmPassword = confirmPasswordField.getText();
                String username = usernameField.getText();

                try {
                    invalidNameField.setVisible(false);
                    invalidEmail.setVisible(false);
                    invalidNumber.setVisible(false);
                    invalidUsername.setVisible(false);
                    passwordMismatch.setVisible(false);
                    weakPassword.setVisible(false);

                    if (userController.signUpValidation(name, email, contactNo, username, password, confirmPassword)) {
                        // Create the dialog
                        JDialog dialog = new JDialog((JFrame) null, "Info", true);
                        dialog.setSize(420, 180);
                        dialog.setLayout(new BorderLayout());
                        dialog.setUndecorated(true); // removes sharp window borders

// Main panel (cream background)
                        JPanel mainPanel = new JPanel(new BorderLayout());
                        mainPanel.setBackground(Color.decode("#F5E6D3"));
                        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#561C32"), 2));

// Message
                        JLabel message = new JLabel(
                                "<html><center>Account created successfully.<br>Please log in to continue.</center></html>",
                                JLabel.CENTER
                        );
                        message.setFont(new Font("Bell MT", Font.BOLD, 18));
                        message.setForeground(Color.decode("#561C32"));
                        message.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));

// Button panel
                        JPanel buttonPanel = new JPanel();
                        buttonPanel.setBackground(Color.decode("#F5E6D3"));

// OK Button
                        JButton okButton = new JButton("OK");
                        okButton.setFont(new Font("Bell MT", Font.BOLD, 14));
                        okButton.setBackground(Color.decode("#561C32"));
                        okButton.setForeground(Color.decode("#F5E6D3"));
                        okButton.setFocusPainted(false);
                        okButton.setBorder(BorderFactory.createEmptyBorder(8, 30, 8, 30));
                        okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

                        okButton.addActionListener(ev -> {
                            try {
                                userController.userActions("Regular");
                            } catch (InvalidInputException ex) {
                                JOptionPane.showMessageDialog(dialog, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            dialog.dispose();
                        });

// Add components
                        buttonPanel.add(okButton);
                        mainPanel.add(message, BorderLayout.CENTER);
                        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

                        dialog.add(mainPanel);
                        dialog.setLocationRelativeTo(null);
                        dialog.setVisible(true);
                    }
                }  catch (InvalidInputException.InvalidName ex) {
                    invalidNameField.setVisible(true);

                } catch (InvalidInputException.InvalidEmail ex) {
                    invalidEmail.setVisible(true);

                } catch (InvalidInputException.InvalidPhone ex) {
                    invalidNumber.setVisible(true);

                } catch (InvalidInputException | IOException ex) {
                    invalidUsername.setVisible(true);
                }  catch (InvalidInputException.WeakPassword ex) {
                    weakPassword.setVisible(true);
                } catch (InvalidInputException.PasswordMismatch ex) {
                    passwordMismatch.setVisible(true);
                }
            }
        });
    }
}
