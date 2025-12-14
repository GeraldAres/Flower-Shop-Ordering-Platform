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
    private JButton btnSmall;
    private JButton btnMedium;
    private JButton btnLarge;
    private MainController mainController;

    public OrderPanel() {

        NewForm newForm = new NewForm();
        Stembtn.setEnabled(true);
        btnSmall.setEnabled(true);

        ImageIcon image1 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/StemBtn.png");
        Image img1 =  image1.getImage().getScaledInstance(200, 55, Image.SCALE_SMOOTH);
        ImageIcon stem = new ImageIcon(img1);
        Stembtn.setIcon(stem);
        //SMALL BOUQUET
        ImageIcon image2 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/smallBqt.png");
        Image img2 =  image2.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon bouquet = new ImageIcon(img2);
        btnSmall.setIcon(bouquet);
        btnSmall.setText("");
        btnSmall.setOpaque(false);
        btnSmall.setContentAreaFilled(false);
        btnSmall.setBorderPainted(false);
        btnSmall.setFocusPainted(false);
        btnSmall.setText("");


        ImageIcon image3 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/mediumBqt.png");
        Image img3 =  image3.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon mBouquet = new ImageIcon(img3);
        btnMedium.setIcon(mBouquet);
        btnMedium.setText("");
        btnMedium.setOpaque(false);
        btnMedium.setContentAreaFilled(false);
        btnMedium.setBorderPainted(false);
        btnMedium.setFocusPainted(false);
        btnMedium.setText("");

        ImageIcon image4 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/largeBqt.png");
        Image img4 =  image4.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon LBouquet = new ImageIcon(img4);
        btnLarge.setIcon(LBouquet);
        btnLarge.setText("");
        btnLarge.setOpaque(false);
        btnLarge.setContentAreaFilled(false);
        btnLarge.setBorderPainted(false);
        btnLarge.setFocusPainted(false);
        btnLarge.setText("");

        ImageIcon image9 = new ImageIcon("src/FlowerOrderSystem/Assets/Animal Illustrations/Catwobg.png");
        Image img9 =  image9.getImage().getScaledInstance(150, 400, Image.SCALE_SMOOTH);
        ImageIcon animal1 = new ImageIcon(img9);
        ImageHolder1.setIcon(animal1);

        ImageIcon image8 = new ImageIcon("src/FlowerOrderSystem/Assets/Animal Illustrations/Squirrel wo bg.png");
        Image img8 =  image8.getImage().getScaledInstance(150, 400, Image.SCALE_SMOOTH);
        ImageIcon animal2 = new ImageIcon(img8);
        ImageHolder2.setIcon(animal2); ///right


        ImageIcon image7 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/prev.png");
        Image img7 =  image7.getImage().getScaledInstance(66, 29, Image.SCALE_SMOOTH);
        ImageIcon prev = new ImageIcon(img7);
        prevButton.setIcon(prev);


        JButton[] buttons = {btnSmall, btnLarge, btnMedium, Stembtn, prevButton};
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

        btnSmall.addActionListener(new ActionListener() {
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
