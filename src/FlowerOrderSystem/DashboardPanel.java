package src.FlowerOrderSystem;

import src.FlowerOrderSystem.Controllers.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DashboardPanel {
    JPanel Dashboard;
    private JButton newOrderButton;
    private JButton myOrdersBtn;
    private JButton availableFlowersbtn;
    private JButton settingsBtn;
    private JLabel LogOut;
    private JLabel ImageHolder;
    private JPanel Main;
    private JPanel Holder;
    private JPanel BusinessName;
    private JPanel MainDashboard;
    private JPanel WelcomePanel;
    private JPanel Holder2;
    private JPanel Left;
    private JPanel ButtonsList;
    private JPanel DogImageHolder;
    private MainController mainController;

    public DashboardPanel(JPanel MainPanel, CardLayout cardLayout){
        ImageIcon img = new ImageIcon("src/FlowerOrderSystem/Assets/Extra/Doggos.png");
        Image imgg =  img.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon set = new ImageIcon(imgg);
        ImageHolder.setIcon(set);

        ImageIcon image1 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/newOrder.png");
        Image img1 = image1.getImage().getScaledInstance(350, 55, Image.SCALE_SMOOTH);
        ImageIcon newOrder = new ImageIcon(img1);
        newOrderButton.setIcon(newOrder);

        ImageIcon image2 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/myOrders.png");
        Image img2 =  image2.getImage().getScaledInstance(350, 55, Image.SCALE_SMOOTH);
        ImageIcon myOrder = new ImageIcon(img2);
        myOrdersBtn.setIcon(myOrder);

        ImageIcon image3 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/availableFlowers.png");
        Image img3 =  image3.getImage().getScaledInstance(350, 55, Image.SCALE_SMOOTH);
        ImageIcon settings = new ImageIcon(img3);
        settingsBtn.setIcon(settings);

        ImageIcon image4 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/settingss.png");
        Image img4 =  image4.getImage().getScaledInstance(350, 55, Image.SCALE_SMOOTH);
        ImageIcon avaiable = new ImageIcon(img4);
        availableFlowersbtn.setIcon(avaiable);


        ImageIcon image6 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/logout.png");
        Image img6=  image6.getImage().getScaledInstance(115, 30, Image.SCALE_SMOOTH);
        ImageIcon log = new ImageIcon(img6);
        LogOut.setIcon(log);

        JButton[] buttons = {newOrderButton, settingsBtn, myOrdersBtn, availableFlowersbtn};
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

        LogOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    mainController.changeDisplay("Regular");
                } catch (InvalidInputException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        newOrderButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    mainController.changeDisplay("NewOrder");
                } catch (InvalidInputException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        myOrdersBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    mainController.changeDisplay("MyOrders");
                } catch (InvalidInputException ex) {}
            }
        });

        availableFlowersbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    mainController.changeDisplay("AvailableFlowers");
                } catch (InvalidInputException ex) {}
            }
        });

        settingsBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    mainController.changeDisplay("Settings");
                } catch (InvalidInputException ex) {}
            }
        });
    }
}
