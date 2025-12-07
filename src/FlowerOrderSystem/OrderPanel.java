package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderPanel {
     JPanel orderPanel;
    private JPanel Holder;
    private JPanel Header;
    private JPanel Body;
    private JPanel Left;
    private JPanel Right;
    private JPanel OrderOptions;
    private JPanel NewForm;
    private JLabel ImageHolder1;
    private JLabel ImageHolder2;
    private JTextField fullName;
    private JPanel Label;
    private JButton stemButton;
    private JButton bouquetButton;
    private JLabel invalidNameLbl;
    private JLabel invalidContactLbl;
    private JLabel invalidEmailAddressLbl;
    private JButton prevButton;
    private JButton Stembtn;
    private JButton Bouquetbtn;
    private JTextField emailAddress;
    private JTextField contactNumber;

    public OrderPanel() {

        NewForm newForm = new NewForm();
        Stembtn.setEnabled(true);
        Bouquetbtn.setEnabled(true);

        ImageIcon image1 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/StemBtn.png");
        Image img1 =  image1.getImage().getScaledInstance(200, 55, Image.SCALE_SMOOTH);
        ImageIcon stem = new ImageIcon(img1);
        Stembtn.setIcon(stem);

        ImageIcon image2 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/BouquetBtn.png");
        Image img2 =  image2.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon bouquet = new ImageIcon(img2);
        Bouquetbtn.setIcon(bouquet);

        ImageIcon image3 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/prev.png");
        Image img3 =  image3.getImage().getScaledInstance(66, 29, Image.SCALE_SMOOTH);
        ImageIcon prev = new ImageIcon(img3);
        prevButton.setIcon(prev);


        Stembtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newForm.createOrder("Stem");
            }
        });

        Bouquetbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newForm.createOrder("Bouquet");
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton[] buttons = {Bouquetbtn, Stembtn, prevButton};
        for(JButton btn : buttons) {
            btn.setOpaque(false);
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(false);
            btn.setFocusPainted(false);
            btn.setText("");

        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hiraya Cebu");
        frame.setContentPane(new OrderPanel().orderPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setVisible(true);
    }

    private void validateInputs(NewForm n) {

        // Reset visibility
        String name = fullName.getText().trim();
        String contact = contactNumber.getText().trim();
        String address = emailAddress.getText().trim();

        try {
            n.createUser(name, address, contact);
            stemButton.setEnabled(true);
            bouquetButton.setEnabled(true);

        } catch (InvalidInputException e) {

            // ANY invalid → disable buttons
            stemButton.setEnabled(false);
            bouquetButton.setEnabled(false);

            // Show the correct error label based on exception message
            switch (e.getMessage()) {

                case "Invalid name":
                    invalidNameLbl.setVisible(true);
                    break;

                case "Invalid email address":
                    invalidEmailAddressLbl.setVisible(true);
                    break;

                case "Invalid contact number":
                    invalidContactLbl.setVisible(true);
                    break;
            }
        }
    }
}
