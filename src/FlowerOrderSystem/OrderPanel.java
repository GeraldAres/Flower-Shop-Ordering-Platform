package src.FlowerOrderSystem;

import src.FlowerOrderSystem.Controllers.MainController;

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
    private MainController mainController;

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


        JButton[] buttons = {Bouquetbtn, Stembtn, prevButton};
        for(JButton btn : buttons) {
            btn.setOpaque(false);
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(false);
            btn.setFocusPainted(false);
            btn.setText("");

        }
    }

    public void setController(MainController mainController) {
        this.mainController = mainController;

        Stembtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainController.changeDisplay("Stem");
                } catch (InvalidInputException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Bouquetbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainController.changeDisplay("Bouquet");
                } catch (InvalidInputException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainController.changeDisplay("Dashboard");
                } catch (InvalidInputException ex) {}

            }
        });
    }
}
