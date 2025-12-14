package src.FlowerOrderSystem;

import src.FlowerOrderSystem.Controllers.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ForgotPassPanel {
    JPanel ForgotPassPnl;
    private JPanel Holder;
    private JPanel BusinessName;
    private JPanel Right;
    private JLabel Welcome;
    private JPanel Left;
    private JButton prevButton;
    private JButton confirmButton;
    private UserController userController;
    private JTextField newPasswordField;
    private JPasswordField confirmPasswordFIeld; // Kept your variable name
    private JTextField usernameFiel;             // Kept your variable name
    private JLabel weakPassword;
    private JLabel passwordMismatch;
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

        if(invalidUsername != null) invalidUsername.setVisible(false);
        if(weakPassword != null) weakPassword.setVisible(false);
        if(passwordMismatch != null) passwordMismatch.setVisible(false);
    }

    public void setController(UserController userController) {
        this.userController = userController;

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    userController.userActions("Login");
                } catch (InvalidInputException ex) {
                    ex.printStackTrace();
                }
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(invalidUsername != null) invalidUsername.setVisible(false);
                if(weakPassword != null) weakPassword.setVisible(false);
                if(passwordMismatch != null) passwordMismatch.setVisible(false);

                String user = usernameFiel.getText();
                String newPass = newPasswordField.getText();
                String confirmPass = new String(confirmPasswordFIeld.getPassword());

                try {
                    userController.resetPasswordValidation(user, newPass, confirmPass);
                    JOptionPane.showMessageDialog(ForgotPassPnl, "Password updated successfully! Please log in.");
                    userController.userActions("Regular");

                } catch (InvalidInputException ex) {
                    String msg = ex.getMessage();

                    if (msg.contains("Username") || msg.contains("exist")) {
                        if(invalidUsername != null) invalidUsername.setVisible(true);
                        else JOptionPane.showMessageDialog(ForgotPassPnl, msg);

                    } else if (msg.contains("match")) {
                        if(passwordMismatch != null) passwordMismatch.setVisible(true);
                        else JOptionPane.showMessageDialog(ForgotPassPnl, msg);

                    } else if (msg.contains("Weak") || msg.contains("format")) {
                        if(weakPassword != null) weakPassword.setVisible(true);
                        else JOptionPane.showMessageDialog(ForgotPassPnl, msg);

                    } else {
                        JOptionPane.showMessageDialog(ForgotPassPnl, msg);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return ForgotPassPnl;
    }
}