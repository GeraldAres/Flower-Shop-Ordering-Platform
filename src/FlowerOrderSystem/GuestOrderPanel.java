package src.FlowerOrderSystem;

import src.FlowerOrderSystem.Controllers.UserController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class GuestOrderPanel {
    JPanel GuestOrder;
    private JPanel Holder;
    private JPanel Header;
    private JPanel Body;
    private JPanel Left;
    private JPanel Right;
    private JPanel CardLayout;
    private JPanel OrderOptions;
    private JPanel NewForm;
    private JLabel ImageHolder1;
    private JLabel ImageHolder2;
    private JPanel GuestDisplay;
    private JTextField fullName;
    private JPanel Label;
    private JPanel Stem;
    private JPanel Bouquet;
    private JButton stemButton;
    private JButton bouquetButton;
    private JLabel invalidNameLbl;
    private JLabel invalidContactLbl;
    private JLabel invalidEmailAddressLbl;
    private JButton prevButton;
    private JTextField emailAddress;
    private JTextField contactNumber;
    private UserController userController;

    public GuestOrderPanel() {

        stemButton.setEnabled(false);
        bouquetButton.setEnabled(false);
        invalidNameLbl.setVisible(false);
        invalidEmailAddressLbl.setVisible(false);
        invalidContactLbl.setVisible(false);

        ImageIcon image1 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/StemBtn.png");
        Image img1 = image1.getImage().getScaledInstance(200, 55, Image.SCALE_SMOOTH);
        stemButton.setIcon(new ImageIcon(img1));

        ImageIcon image2 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/BouquetBtn.png");
        Image img2 = image2.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        bouquetButton.setIcon(new ImageIcon(img2));

        ImageIcon image3 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/prev.png");
        Image img3 = image3.getImage().getScaledInstance(66, 29, Image.SCALE_SMOOTH);
        prevButton.setIcon(new ImageIcon(img3));

        JButton[] buttons = {stemButton, bouquetButton, prevButton};
        for (JButton btn : buttons) {
            btn.setOpaque(false);
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(false);
            btn.setFocusPainted(false);
            btn.setText("");
        }
    }

    public void setUserController(UserController userController) {
        this.userController = userController;

        DocumentListener listener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { updateButtons(); }
            public void removeUpdate(DocumentEvent e) { updateButtons(); }
            public void changedUpdate(DocumentEvent e) { updateButtons(); }
        };

        fullName.getDocument().addDocumentListener(listener);
        emailAddress.getDocument().addDocumentListener(listener);
        contactNumber.getDocument().addDocumentListener(listener);

        stemButton.addActionListener(e -> {
            try {
                userController.userActions("Stem");
            } catch (InvalidInputException ex) {
                throw new RuntimeException(ex);
            }
        });

        bouquetButton.addActionListener(e -> {
            try {
                userController.userActions("Bouquet");
            } catch (InvalidInputException ex) {
                throw new RuntimeException(ex);
            }
        });

        prevButton.addActionListener(e -> {
            try {
                userController.userActions("prev");
            } catch (InvalidInputException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void updateButtons() {
        boolean valid = true;

        String nameText = fullName.getText().trim();
        if (!nameText.isEmpty()) {
            try {
                userController.validateName(nameText);
                invalidNameLbl.setVisible(false);
            } catch (InvalidInputException.InvalidName e) {
                invalidNameLbl.setVisible(true);
                valid = false;
            }
        } else {
            invalidNameLbl.setVisible(false);
            valid = false;
        }

        String emailText = emailAddress.getText().trim();
        if (!emailText.isEmpty()) {
            try {
                userController.validateEmail(emailText);
                invalidEmailAddressLbl.setVisible(false);
            } catch (InvalidInputException.InvalidEmail e) {
                invalidEmailAddressLbl.setVisible(true);
                valid = false;
            }
        } else {
            invalidEmailAddressLbl.setVisible(false);
            valid = false;
        }

        String contactText = contactNumber.getText().trim();
        if (!contactText.isEmpty()) {
            try {
                userController.validatePhone(contactText);
                invalidContactLbl.setVisible(false);
            } catch (InvalidInputException.InvalidPhone e) {
                invalidContactLbl.setVisible(true);
                valid = false;
            }
        } else {
            invalidContactLbl.setVisible(false);
            valid = false;
        }

        stemButton.setEnabled(valid);
        bouquetButton.setEnabled(valid);
    }
}
