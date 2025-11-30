package src.FlowerOrderSystem;

import javax.swing.*;
import java.awt.*;

public class Sample {

    private JPanel Sample;
    private JButton newOrderButton;
    private JButton myOrdersBtn;
    private JButton availableFlowersbtn;
    private JButton settingsBtn;
    private JButton prevButton;
    private JLabel ImageHolder;
    private JLabel LogOut;
    private JPanel Holder;
    private JPanel BusinessName;
    private JPanel MainDashboard;
    private JPanel WelcomePanel;
    private JPanel Holder2;
    private JPanel Left;
    private JPanel ButtonsList;
    private JPanel DogImageHolder;

    public Sample() {
        ImageIcon img = new ImageIcon("src/FlowerOrderSystem/Assets/Extra/Doogo.png");
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

        ImageIcon image5 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/prev.png");
        Image img5=  image5.getImage().getScaledInstance(66, 29, Image.SCALE_SMOOTH);
        ImageIcon prev = new ImageIcon(img5);
        prevButton.setIcon(prev);

        ImageIcon image6 = new ImageIcon("src/FlowerOrderSystem/Assets/ImageButtons/logout.png");
        Image img6=  image6.getImage().getScaledInstance(129, 43, Image.SCALE_SMOOTH);
        ImageIcon log = new ImageIcon(img6);
        LogOut.setIcon(log);

        JButton[] buttons = {newOrderButton, settingsBtn, myOrdersBtn, availableFlowersbtn, prevButton};
        for(JButton btn : buttons) {
            btn.setOpaque(false);
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(false);
            btn.setFocusPainted(false);
            btn.setText("");

        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Order System");
        frame.setContentPane(new Sample().Sample);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 1440);
        frame.setLocationRelativeTo(null); // center window
        frame.setVisible(true);
    }
}
